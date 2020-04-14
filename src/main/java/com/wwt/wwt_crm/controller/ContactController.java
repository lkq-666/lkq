package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Contact;
import com.wwt.wwt_crm.entity.Employee;
import com.wwt.wwt_crm.service.ContactService;
import com.wwt.wwt_crm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Contact> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Contact> iPage=contactService.listCmC(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/")
    public Map add(Contact contact){
        Map<String,Object> map=new HashMap<>();
        contact.setUpdateTime(StringUtils.getNowTime());
        contact.setCreateTime(contact.getUpdateTime());
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        contact.setEmpId(employee.getEmpId());
        if (contactService.save(contact)){
            map.put("state",1);
        }
        return  map;
    }
    @DeleteMapping("/del/{contactId}")
    public Map del(@PathVariable Integer contactId){
        Map<String,Object> map=new HashMap<>();
        Contact contact=new Contact();
        contact.setIsDel(1);
        contact.setContactId(contactId);
        map.put("state",contactService.updateById(contact));
        return map;
    }
}
