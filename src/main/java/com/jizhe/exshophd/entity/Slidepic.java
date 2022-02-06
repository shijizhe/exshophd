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
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Slidepic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sli_id", type = IdType.AUTO)
    private Integer sliId;

    private Integer sliUserid;

    private String sliTitle;

    private String sliSrc;

    private Integer sliIsuse;

    private String sliUrl;


}
