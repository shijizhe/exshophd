package com.jizhe.exshophd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jizhe.exshophd.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-04-16
 */
public interface UserService extends IService<User> {


    Boolean selectbyPhone(String phone);
    Boolean selectbyName(String name);
    Boolean selectbyMail(String mail);
    Boolean addUser(User user);
    User login(String accout,String password);
    User finduser(String id);
    Boolean changePass(String uid,String upass);
    Boolean resetPass(String uphone,String upass);


}
