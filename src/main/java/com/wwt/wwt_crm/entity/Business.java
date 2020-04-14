package com.wwt.wwt_crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-03-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business  extends BaseEntity {


    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

    private String busubessName;

    private String head;

    private String telphone;

    private String description;



}
