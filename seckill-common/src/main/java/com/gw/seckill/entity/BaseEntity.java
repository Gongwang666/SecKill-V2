package com.gw.seckill.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
　* @描述:     基础实体类，包含各实体公用属性 .
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2017/12/28 14:20
  */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 主键ID **/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//分页，当前页数
	@Transient
	private Integer page = 1;
	//分页，每页行数
	@Transient
	private Integer rows = 10;

	/*@Transient
	*//** 创建时间 **//*
	private Date createTime;*/

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/** 主键ID **/
	public Long getId() {
		return id;
	}
	
	/** 主键ID **/
	public void setId(Long id) {
		this.id = id;
	}

	/** 创建时间 **//*
	public Date getCreateTime() {
		return createTime;
	}
	
	*//** 创建时间 **//*
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}*/
}
