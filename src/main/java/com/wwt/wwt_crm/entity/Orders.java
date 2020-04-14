package com.wwt.wwt_crm.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author PIGS
 * @since 2020-03-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends BaseEntity {


    @TableId(value = "orders_id", type = IdType.AUTO)
    private Integer ordersId;

    private Integer businessId;

    private BigDecimal totalPrice;

    private Integer customerId;

    @TableField(exist = false)
    private Business business;
    @TableField(exist = false)
    private Customer customer;
}
