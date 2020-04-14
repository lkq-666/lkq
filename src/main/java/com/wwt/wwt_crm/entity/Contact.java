package com.wwt.wwt_crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Contact extends  BaseEntity {


    @TableId(value = "contact_id", type = IdType.AUTO)
    private Integer contactId;

    private String way;

    private String content;

    private Integer customerId;

    private Integer empId;
    @TableField(exist = false)
    private Customer customer;


}
