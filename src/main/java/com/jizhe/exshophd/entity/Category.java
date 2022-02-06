package com.jizhe.exshophd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Ya
 * @since 2021-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ca_id", type = IdType.AUTO)
    private Long caId;

    private String caName;

    private Long caParentId;

    private Integer caLevel;

    private String caGroup;

    private String caIcon;

    private String caPath;


}
