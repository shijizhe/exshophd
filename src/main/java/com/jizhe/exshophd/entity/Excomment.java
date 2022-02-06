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
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Excomment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cm_id", type = IdType.AUTO)
    private Integer cmId;

    private Integer cmOrderid;

    private Integer cmGoodsid;

    private Integer cmBuyerid;

    private Integer cmStar;

    private String cmContent;

    private String cmReply;

    private Integer cmSellerid;


}
