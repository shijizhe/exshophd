package com.jizhe.exshophd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Ya
 * @since 2021-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Harminfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ha_id", type = IdType.AUTO)
    private Integer haId;

    private Integer haGoodsid;

    private Integer haUserid;

    private Integer haCount;

    private LocalDateTime haCreatedtime;

    private Integer haResult;

    private String haReason;

    private String haOption;


}
