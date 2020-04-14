package com.wwt.wwt_crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.EmpRole;
import com.wwt.wwt_crm.entity.Employee;
import com.wwt.wwt_crm.mapper.EmpRoleMapper;
import com.wwt.wwt_crm.mapper.EmployeeMapper;
import com.wwt.wwt_crm.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwt.wwt_crm.utils.ShiroUtils;
import com.wwt.wwt_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Override
    public IPage<Employee> selectList(Page<Employee> page) {
        return employeeMapper.selectList(page);
    }

    @Override
    public Employee selectByName(String name) {
        return employeeMapper.selectByName(name);
    }

    @Override
    public Integer add(Employee employee,Integer roleId) {
        employee.setSalt(ShiroUtils.randomSalt());
        employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        employee.setCreateTime(StringUtils.getNowTime());
        employee.setUpdateTime(employee.getCreateTime());
        employee.setIsDel(0);
        int result =  employeeMapper.insert(employee);
        int empId = employee.getEmpId();
        EmpRole empRole = new EmpRole(empId,roleId);
        empRole.setCreateTime(StringUtils.getNowTime());
        empRole.setUpdateTime(empRole.getCreateTime());
        empRole.setIsDel(0);
        empRoleMapper.insert(empRole);
        return result;
    }

    @Override
    public Integer updateById(Employee employee, Integer roleId) {
        if (!"".equals(employee.getPwd()) ){
            employee.setSalt(ShiroUtils.randomSalt());
            employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        }else {
            employee.setPwd(null);
        }
        employee.setUpdateTime(StringUtils.getNowTime());
        int result =  employeeMapper.updateById(employee);
        System.out.println(roleId);
        System.out.println(result);

        if (roleId!=null){
            EmpRole empRole=new EmpRole();
            empRole.setRoleId(roleId);
            empRole.setUpdateTime(employee.getUpdateTime());
            QueryWrapper<EmpRole> queryWrapper=new QueryWrapper<>();
            if (empRoleMapper.selectOne(queryWrapper.eq("emp_id",employee.getEmpId()))==null){
                empRole.setCreateTime(employee.getUpdateTime());
                empRole.setEmpId(employee.getEmpId());
                empRole.setIsDel(0);
                empRoleMapper.insert(empRole);
            }else{
                QueryWrapper<EmpRole> queryWrapper1=new QueryWrapper<>();
                empRoleMapper.update(empRole,queryWrapper1.eq("emp_id",employee.getEmpId()));
            }
        }
        return result;
    }
}
