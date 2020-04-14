package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Business;
import com.wwt.wwt_crm.service.BusinessService;
import com.wwt.wwt_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @GetMapping("/list/")
    public List<Business> lists(){
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        return businessService.list(wrapper.eq("is_del",0));
    }
    @GetMapping("/")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Business> page1 = new Page<Business>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        IPage<Business> iPage=businessService.page(page1,wrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/")
    public Map add(Business business){
        Map<String,Object> map=new HashMap<>();
        business.setUpdateTime(StringUtils.getNowTime());
        business.setCreateTime(business.getUpdateTime());
        if (businessService.save(business)){
            map.put("state",1);
        }
        return map;
    }
    @DeleteMapping("/del/{businessId}")
    public Map del(@PathVariable Integer businessId){
        Map<String,Object> map=new HashMap<>();
        Business business=new Business();
        business.setIsDel(1);
        business.setUpdateTime(StringUtils.getNowTime());
        business.setBusinessId(businessId);
        map.put("state",businessService.updateById(business));
        return map;
    }
    @PutMapping("/")
    public Map update(Business business){
        System.out.println("lkq");
        Map<String,Object> map=new HashMap<>();
        business.setUpdateTime(StringUtils.getNowTime());
        map.put("state",businessService.updateById(business));
        return map;
    }


}
