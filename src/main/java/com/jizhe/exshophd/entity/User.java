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
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String uname;

    private String upassword;

    private String uphone;

    private String uavatar;


    private String umail;

    /**
     * 0:普通用户；1:管理员
     */
    private Integer urole;
    /**
     * 0:正常账号;1：封禁中
     */
    private Integer uisban;

    private LocalDateTime ubandate;

    public User() {
    }

    public User(String uname, String uphone, String upassword) {
        super();
        uisban = 0;
        urole = 0;
        this.uname = uname;
        this.upassword = upassword;
        this.uphone = uphone;
    }

}
