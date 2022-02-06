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
 * @since 2021-05-17
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Orderstatus implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "sa_id", type = IdType.AUTO)
      private Integer saId;

    private Integer saOrderid;

    private String saOrdernum;

    private Integer saStatus;

    private String saStatusinfo;

    private LocalDateTime saCreadtedtime;

    private String saExinfo1;

    private String saExinfo2;


}
