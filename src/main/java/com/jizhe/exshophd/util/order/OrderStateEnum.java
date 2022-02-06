package com.jizhe.exshophd.util.order;

import lombok.Getter;

@Getter
public enum OrderStateEnum {

    ORDER(1,"用户下单/待发货"),
    TRANSPORT(3,"运输中"),
    RECEIVED(4,"已签收"),
    REVIEWED(5,"评价完成"),
    AFTERSALE(6,"售后中"),;


    private int code;
    private String description;

    private OrderStateEnum(int code,String description)
    {
        this.code = code;
        this.description = description;
    }

}
