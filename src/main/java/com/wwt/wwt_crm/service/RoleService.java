package com.wwt.wwt_crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
public interface RoleService extends IService<Role> {
    IPage<Role> roleList(Page<Role> page);

    Integer add(Role role,Integer deptId);
    Integer updateById(Role role,Integer deptId);
}
