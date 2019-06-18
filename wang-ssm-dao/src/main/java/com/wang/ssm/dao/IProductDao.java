package com.wang.ssm.dao;

import com.wang.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {
    /**
     * 查询所有产品信息
     * @return
     */
    @Select(value = "select * from product")
    List<Product> findAll();

    @Insert(value = "insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);

    @Select(value = "select * from product where id = #{id}")
    List<Product> findById(String id);
}
