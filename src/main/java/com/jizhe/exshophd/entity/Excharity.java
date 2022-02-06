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
 * @since 2021-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Excharity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ch_id", type = IdType.AUTO)
    private Integer chId;

    private String chName;

    private String chContent;

    private Integer chUserid;

    private String chPhone;

    private LocalDateTime chCreatetime;

    private Integer chStatus;



}
