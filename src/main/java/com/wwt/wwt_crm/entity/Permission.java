package com.wwt.wwt_crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity {


    @TableId(value = "perm_id", type = IdType.AUTO)
    private Integer permId;

    private String permName;

    private String url;

    private String permission;



}
