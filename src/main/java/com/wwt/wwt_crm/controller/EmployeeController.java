package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Employee;
import com.wwt.wwt_crm.service.EmployeeService;
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
 * @since 2020-03-23
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public Map getList(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Employee> page1 = new Page<Employee>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Employee> iPage=employeeService.selectList(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/")
    public Map add(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.add(employee,roleId));
        return result;
    }
    @DeleteMapping("/del/{empId}")
    public Map del(@PathVariable Integer empId){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setIsDel(1);
        employee.setUpdateTime(StringUtils.getNowTime());
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.updateById(employee));
        return result;
    }
    @PutMapping("/")
    public Map put(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.updateById(employee,roleId));
        return result;
    }

}
