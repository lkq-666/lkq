package com.wwt.wwt_crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
 * @since 2020-03-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role  extends BaseEntity {

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;
    
    @TableField(exist = false)
    private List<Permission> permissionList;
    @TableField(exist = false)
    private List<Department> departmentList;

}
