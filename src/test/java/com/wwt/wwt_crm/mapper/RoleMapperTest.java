package com.wwt.wwt_crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;
    @Test
    public void list(){
        for (Role role:roleMapper.selectList(null)){
            System.out.println(role);
        }
    }
    @Test
    public void  aaa(){
        Page<Role> page1 = new Page<Role>();
        page1.setSize(1);
        page1.setCurrent(10);
        IPage<Role> iPage=roleMapper.roleList(page1);
        for (Role role:iPage.getRecords()){
            System.out.println(role);
        }
    }
}