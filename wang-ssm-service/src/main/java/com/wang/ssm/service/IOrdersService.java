package com.wang.ssm.service;

import com.wang.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 查询商品信息
     */
    public List<Orders> findAll(Integer page,Integer size);

    /**
     * 通过id查询订单
     * @param id
     * @return
     */
    public Orders findById(String id);
}
