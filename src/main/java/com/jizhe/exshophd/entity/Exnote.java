package com.jizhe.exshophd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ya
 * @since 2021-05-19
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Exnote implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "n_id", type = IdType.AUTO)
      private Integer nId;

    private String nTitle;

    private String nContent;

    private Integer nAdminId;

    private LocalDateTime nCreatetime;


}
