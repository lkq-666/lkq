package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Employee;
import com.wwt.wwt_crm.entity.Role;
import com.wwt.wwt_crm.service.RoleService;
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
 * @since 2020-03-23
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/")
    public List<Role> list(){
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        return roleService.list(queryWrapper.eq("is_del",0));
    }
    @GetMapping("/role")
    public Map roleList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Role> page1 = new Page<Role>();
        page1.setSize(limit);
        page1.setCurrent(page);
        IPage<Role> iPage=roleService.roleList(page1);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/")
    public Map add(Role role,Integer deptId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.add(role,deptId));
        return result;
    }
    @DeleteMapping("/del/{roleId}")
    public Map delete(@PathVariable Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        Role role=new Role();
        role.setRoleId(roleId);
        role.setUpdateTime(StringUtils.getNowTime());
        role.setIsDel(1);
        result.put("state",roleService.updateById(role));
        return result;

    }
    @PutMapping("/")
    public Map update(Role role,Integer deptId){
        Map<String,Object> map=new HashMap<>();
        map.put("state",roleService.updateById(role,deptId));
        return map;
    }
}
