package com.gw.seckill.service.mall.biz;

import com.gw.seckill.core.admin.dao.GoodsMapper;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.dto.DTOOrder;
import com.gw.seckill.facade.mall.dto.DTOOrderInfo;
import com.gw.seckill.facade.mall.dto.DTOOrderItems;
import com.gw.seckill.facade.mall.entity.Order;
import com.gw.seckill.facade.mall.entity.OrderItems;
import com.gw.seckill.service.mall.dao.OrderItemsMapper;
import com.gw.seckill.service.mall.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("orderBiz")
public class OrderBiz {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemsMapper orderItemsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Transactional
    public Integer addToOrder(DTOOrderInfo orderInfo,Integer userId) {
        Order order = new Order();
        Goods goods= goodsMapper.selectByPrimaryKey(orderInfo.getGoodsId());
        String uuid = UUID.randomUUID().toString().replace("-","");
        order.setOrderUUID(uuid);
        order.setUserId(userId);
        order.setSign(0);
        order.setOrderTime(new Date());
        orderMapper.insert(order);
        Order order1 = new Order();
        order1.setOrderUUID(uuid);
        Order orderInfo1 = orderMapper.selectOne(order1);
        OrderItems orderItems = new OrderItems();
        orderItems.setGoodsId(orderInfo.getGoodsId());
        orderItems.setGoodsNum(orderInfo.getGoodsNum());
        orderItems.setOrderId(orderInfo1.getId());
        //orderItems.setOrderTime(new Date());
        Double sumMoney = (double)(orderInfo.getGoodsNum()*goods.getShopPrice());
        orderItems.setSumMoney(sumMoney);
        orderItemsMapper.insert(orderItems);
        OrderItems odi = new OrderItems();
        odi.setOrderId(orderInfo1.getId());
        List<OrderItems> orderItemsList = orderItemsMapper.select(odi);
        Double totalMoney = 0.0;
        for(OrderItems oi:orderItemsList){
            totalMoney += oi.getSumMoney();
        }
        orderInfo1.setTotalMoney(totalMoney);
        orderMapper.updateByPrimaryKeySelective(orderInfo1);
        return orderInfo1.getId().intValue();
    }

    public List<DTOOrder> getUnPayOrders(Long userId) {
        Order order = new Order();
        order.setUserId(userId.intValue());
        order.setSign(0);
        List<Order> orderList = orderMapper.select(order);
        if(orderList==null&&orderList.size()<=0){
            return null;
        }
        List<DTOOrder> dtoOrderList = new ArrayList<DTOOrder>();
        for(Order or:orderList){
            DTOOrder dtoOrder = new DTOOrder();
            OrderItems odi = new OrderItems();
            odi.setOrderId(or.getId());
            List<OrderItems> orderItemsList = orderItemsMapper.select(odi);
            List<DTOOrderItems> dtoOrderItemsList = new ArrayList<DTOOrderItems>();
            for(OrderItems oi:orderItemsList){
                DTOOrderItems dtoOrderItems = new DTOOrderItems();
                Goods goods = goodsMapper.selectByPrimaryKey(oi.getGoodsId());
                dtoOrderItems.setGoods(goods);
                dtoOrderItems.setOrderItems(oi);
                dtoOrderItemsList.add(dtoOrderItems);
            }
            dtoOrder.setOrder(or);
            dtoOrder.setDtoOrderItemsList(dtoOrderItemsList);
            dtoOrderList.add(dtoOrder);
        }
        return dtoOrderList;
    }
}
