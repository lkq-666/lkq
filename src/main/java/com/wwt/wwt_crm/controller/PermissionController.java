package com.wwt.wwt_crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Permission;
import com.wwt.wwt_crm.service.PermissionService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/")
    public List<Permission> list(){
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
        return permissionService.list(queryWrapper.eq("is_del",0));
    }
    @GetMapping("/per")
    public Map pageList(Integer page, Integer limit){
        Map<String,Object> map=new HashMap<>();
        Page<Permission> page1 = new Page<Permission>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
        IPage<Permission> iPage=permissionService.page(page1,queryWrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/")
    public Map add(Permission permission){
        Map<String,Object> map=new HashMap<>();
        permission.setUpdateTime(StringUtils.getNowTime());
        permission.setCreateTime(permission.getUpdateTime());
        permission.setIsDel(0);
        if (permissionService.save(permission)){
            map.put("state",1);
        }
        return map;
    }
    @DeleteMapping("/del/{permId}")
    public Map del(@PathVariable Integer permId){
        Map<String,Object> map=new HashMap<>();
        Permission permission=new Permission();
        permission.setIsDel(1);
        permission.setUpdateTime(StringUtils.getNowTime());
        permission.setPermId(permId);
        map.put("state",permissionService.updateById(permission));
        return map;
    }
    @PutMapping("/")
    public Map update(Permission permission){
        Map<String,Object> map=new HashMap<>();
        permission.setUpdateTime(StringUtils.getNowTime());
        map.put("state",permissionService.updateById(permission));
        return map;
    }

}
