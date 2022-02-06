package com.jizhe.exshophd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ya
 * @since 2021-04-30
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Address implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "adid", type = IdType.AUTO)
      private Integer adid;

    private Integer aduserid;

    private String adname;

    private String adphone;

    private String adprovince;

    private String adcity;

    private String adcounty;

    private String adpca;

    private String addetail;

    private Integer adisdefault;


}
