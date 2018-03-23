package com.gw.seckill.common.web.exception.handler;

import com.gw.seckill.common.web.exception.DescribeException;
import com.gw.seckill.common.web.exception.enums.ExceptionEnum;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.common.web.exception.utils.ResultUtil;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class WebGlobalExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebGlobalExceptionHandler.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    /*@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e){
        if(e instanceof DescribeException){
            DescribeException pingjiaException = (DescribeException) e;
            return ResultUtil.error(pingjiaException.getCode(),pingjiaException.getMessage());
        }

        LOGGER.error("【系统异常】{}",e);
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }*/

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionGet(Exception e){
        ModelAndView modelAndView = new ModelAndView("/404");
        if(e instanceof DescribeException){
            DescribeException pingjiaException = (DescribeException) e;
            modelAndView.addObject("message",e.getMessage());
            return modelAndView;
        }

        LOGGER.error("【系统异常】{}",e);
        modelAndView.addObject("message",e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ModelAndView unauthorizedExceptionGet(Exception e){
        ModelAndView modelAndView = new ModelAndView("/404");
        LOGGER.error("权限异常:",e);
        modelAndView.addObject("message","对不起，您没有此权限！");
        return modelAndView;
    }
    //登录次数超过5次，没有登陆成功
    @ResponseBody
    @ExceptionHandler(value = ExcessiveAttemptsException.class)
    public ModelAndView excessiveAttemptsExceptionGet(Exception e){
        ModelAndView modelAndView = new ModelAndView("/user/login");
        LOGGER.error("尝试登录超过次数限制:",e);
        modelAndView.addObject("message","对不起，超过登录次数，10分钟内，帐号将被锁定！");
        return modelAndView;
    }
}
