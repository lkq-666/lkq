package com.wwt.wwt_crm.entity;

import java.time.LocalDateTime;
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
 * @since 2020-03-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRole extends BaseEntity {

    private Integer empId;

    private Integer roleId;



}
