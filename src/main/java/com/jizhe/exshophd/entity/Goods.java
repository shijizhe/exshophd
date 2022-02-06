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
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gid", type = IdType.AUTO)
    private Long gid;

    private String gname;

    private Long gcateid;

    private Integer gownerid;

    private Long gprice;

    private String gdetail;

    private Integer gison;

    private String gcover;

    private LocalDateTime gaddtime;

    private LocalDateTime gupdatetime;

    public Goods() {
    }

}
