package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Orders;
import com.wwt.wwt_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Orders> page1 = new Page<Orders>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Orders> iPage=ordersService.selectOrders(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @DeleteMapping("/del/{ordersId}")
    public Map del(@PathVariable Integer ordersId){
        Map<String,Object> map=new HashMap<>();
        Orders orders=new Orders();
        orders.setOrdersId(ordersId);
        orders.setIsDel(1);
        orders.setUpdateTime(StringUtils.getNowTime());
        map.put("state",ordersService.updateById(orders));
        return map;
    }
    @PostMapping("/")
    public Map add(Orders orders){
        Map<String,Object> map=new HashMap<>();
        map.put("state",ordersService.add(orders));
        return map;
    }
    @PutMapping("/")
    public Map update(Orders orders){
        Map<String,Object> map=new HashMap<>();
        orders.setUpdateTime(StringUtils.getNowTime());
        map.put("state",ordersService.updateById(orders));
        return map;
    }
}
