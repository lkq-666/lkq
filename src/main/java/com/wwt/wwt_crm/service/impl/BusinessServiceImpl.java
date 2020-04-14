package com.wwt.wwt_crm.service.impl;

import com.wwt.wwt_crm.entity.Business;
import com.wwt.wwt_crm.mapper.BusinessMapper;
import com.wwt.wwt_crm.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@Service
@Transactional
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

}
