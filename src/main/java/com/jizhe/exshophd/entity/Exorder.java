package com.jizhe.exshophd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Exorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "or_id", type = IdType.AUTO)
    private Integer orId;

    private String orNo;

    private Integer orSellerId;

    private Integer orGoodsId;

    private Integer orGoodsNum;

    private Integer orPrice;

    private Integer orAdressId;

    /**
     * 1：用户下单
     */
    private Integer orStatus;

    private String orExpressno;

    private String orExpresstype;

    private Integer orBuyerId;

    private LocalDateTime orUpdatetime;

    @TableField(exist = false)
    private String orGoodsName;

    @TableField(exist = false)
    private String orSellerName;

    @TableField(exist = false)
    private String orBuyerName;

    @TableField(exist = false)
    private String orAddressName;

    @TableField(exist = false)
    private String orAddressPhone;

    @TableField(exist = false)
    private String cmContent;

    @TableField(exist = false)
    private Integer cmStar;

    @TableField(exist = false)
    private String cmReply;




}
