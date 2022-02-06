package com.jizhe.exshophd.mapper;

import com.jizhe.exshophd.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ya
 * @since 2021-04-16
 */
public interface UserMapper extends BaseMapper<User> {
    Boolean changePassword(@Param("uid")String uid,@Param("upassword")String upassword);

    Boolean resetPassword(@Param("uphone")String uphone,@Param("upassword")String upassword);

}
