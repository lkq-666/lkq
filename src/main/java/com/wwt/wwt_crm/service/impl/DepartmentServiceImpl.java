package com.wwt.wwt_crm.service.impl;

import com.wwt.wwt_crm.entity.Department;
import com.wwt.wwt_crm.mapper.DepartmentMapper;
import com.wwt.wwt_crm.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
