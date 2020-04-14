package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Department;
import com.wwt.wwt_crm.service.DepartmentService;
import com.wwt.wwt_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> list(){
        QueryWrapper<Department> queryWrapper=new QueryWrapper<>();
        return departmentService.list(queryWrapper.eq("is_del",0));
    }
    @GetMapping("/dep")
    public Map depList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Department> page1 = new Page<Department>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Department> queryWrapper=new QueryWrapper<>();
        IPage<Department> iPage=departmentService.page(page1,queryWrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/")
    public Map add(Department department){
        Map<String,Object> map=new HashMap<>();
        department.setCreateTime(StringUtils.getNowTime());
        department.setUpdateTime(department.getCreateTime());
        department.setIsDel(0);
        if (departmentService.save(department)){
            map.put("state",1);
        }
        return map;
    }
    @DeleteMapping("/del/{deptId}")
    public Map del(@PathVariable Integer deptId){
        Map<String,Object> map=new HashMap<>();
        Department department=new Department();
        department.setUpdateTime(StringUtils.getNowTime());
        department.setIsDel(1);
        department.setDeptId(deptId);
        map.put("state",departmentService.updateById(department));
        return map;
    }
    @PutMapping("/")
    public Map update(Department department){
        Map<String,Object> map=new HashMap<>();
        department.setUpdateTime(StringUtils.getNowTime());
        map.put("state",departmentService.updateById(department));
        return map;
    }
}
