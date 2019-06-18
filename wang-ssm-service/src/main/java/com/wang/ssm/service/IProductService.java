package com.wang.ssm.service;

import com.wang.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有产品信息
     * @return
     */
    public List<Product> findAll();

    /**
     * 添加产品信息
     * @param product
     */
    public void addProduct(Product product);
}
