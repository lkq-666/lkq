package com.wwt.wwt_crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-23
 */
public interface EmployeeService extends IService<Employee> {
    IPage<Employee> selectList(Page<Employee> page);

    Employee selectByName(String name);

    Integer add(Employee employee,Integer roleId);
    Integer updateById(Employee employee,Integer roleId);

}
