package com.jizhe.exshophd.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class CateTree implements Serializable{
    private static final long serialVersionUID=1L;
    private Long caId;
    private String caName;
    private String caIcon;
    private Integer caLevel;
    private List<Category> children;

}


