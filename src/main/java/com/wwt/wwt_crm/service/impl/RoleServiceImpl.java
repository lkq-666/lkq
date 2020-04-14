package com.wwt.wwt_crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import com.wwt.wwt_crm.entity.DeptRole;
import com.wwt.wwt_crm.entity.Role;
import com.wwt.wwt_crm.mapper.DeptRoleMapper;
import com.wwt.wwt_crm.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwt.wwt_crm.service.RoleService;
import com.wwt.wwt_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DeptRoleMapper deptRoleMapper;
    @Override
    public IPage<Role> roleList(Page<Role> page) {
        return roleMapper.roleList(page);
    }

    @Override
    public Integer add(Role role, Integer deptId) {
        role.setCreateTime(StringUtils.getNowTime());
        role.setUpdateTime(role.getCreateTime());
        role.setIsDel(0);
        roleMapper.insert(role);
        Integer roleId=role.getRoleId();
        DeptRole deptRole=new DeptRole(deptId,roleId);
        deptRole.setCreateTime(StringUtils.getNowTime());
        deptRole.setUpdateTime(deptRole.getCreateTime());
        deptRole.setIsDel(0);
        Integer r=deptRoleMapper.insert(deptRole);
        return r;
    }

    @Override
    public Integer updateById(Role role, Integer deptId) {
        role.setUpdateTime(StringUtils.getNowTime());
        Integer a=roleMapper.updateById(role);
        if (deptId!=null){
            DeptRole deptRole=new DeptRole(deptId,role.getRoleId());
            deptRole.setUpdateTime(StringUtils.getNowTime());
            QueryWrapper<DeptRole> queryWrapper=new QueryWrapper<>();
            deptRoleMapper.update(deptRole,queryWrapper.eq("role_id",role.getRoleId()));
        }
        return a;
    }
}
