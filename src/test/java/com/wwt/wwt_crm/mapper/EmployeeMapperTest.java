package com.wwt.wwt_crm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void list(){
       /* for (Employee employee:employeeMapper.selectList(null)){
            System.out.println(employee);
        }*/
    }
    @Test
    public void login(){
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
        System.out.println(
                employeeMapper.selectOne(queryWrapper.eq("emp_name","admin")
                .eq("pwd","123456")));
    }
    @Test
    public void listS(){
        Page<Employee> page = new Page<Employee>();
        page.setSize(1);
        page.setCurrent(2);
        System.out.println(employeeMapper.selectList(page).getRecords());
    }
    @Test
    public void emp(){
        System.out.println(employeeMapper.selectByName("admin"));
    }
}