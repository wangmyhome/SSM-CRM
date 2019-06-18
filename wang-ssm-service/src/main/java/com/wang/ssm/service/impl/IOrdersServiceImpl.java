package com.wang.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.wang.ssm.dao.IOrderDao;
import com.wang.ssm.domain.Orders;
import com.wang.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Orders> findAll(Integer page,Integer size) {
        //参数page 是页码值   参数page 代表是每页显示条数
        PageHelper.startPage(page, size);
        List<Orders> list = orderDao.findAll();
        return list;
    }

    @Override
    public Orders findById(String id) {
        return orderDao.findById(id);
    }
}
