package com.wwt.wwt_crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwt.wwt_crm.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    IPage<Orders> selectOrders(Page<Orders>page ,Integer empId);
}
