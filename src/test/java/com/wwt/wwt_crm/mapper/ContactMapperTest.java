package com.wwt.wwt_crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactMapperTest {
    @Autowired
    private ContactMapper contactMapper;
    @Test
    public void list(){
        Page<Contact> page1 = new Page<>();
        page1.setSize(10);
        page1.setCurrent(1);
        IPage<Contact> iPage=contactMapper.listCmC(page1,3);
        for (Contact contact:iPage.getRecords()){
            System.out.println(contact);
        }
        /*for (Contact contact:contactMapper.listCmc()){
            System.out.println(contact);
        }*/
    }
}