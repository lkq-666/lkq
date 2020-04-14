package com.wwt.wwt_crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersMapperTest {
    @Autowired
    private OrdersMapper ordersMapper;
    @Test
    public void list(){
        Page<Orders> page1 = new Page<>();
        page1.setSize(10);
        page1.setCurrent(1);
        IPage<Orders> iPage=ordersMapper.selectOrders(page1,3);
        for (Orders orders:iPage.getRecords()){
            System.out.println(orders);
        }
    }
}