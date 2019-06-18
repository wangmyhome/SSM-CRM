package com.wang.ssm.service.impl;

import com.wang.ssm.dao.IProductDao;
import com.wang.ssm.domain.Product;
import com.wang.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        List<Product> all = productDao.findAll();
        for (Product p:
            all ) {
            System.out.println(p);
        }
        return productDao.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }
}
