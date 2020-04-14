package com.wwt.wwt_crm.mapper;

import com.wwt.wwt_crm.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    public void list(){
        for (Department department:departmentMapper.selectList(null)){
            System.out.println(department);
        }
    }
}