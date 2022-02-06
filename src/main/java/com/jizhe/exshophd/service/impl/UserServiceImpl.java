package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jizhe.exshophd.entity.User;
import com.jizhe.exshophd.mapper.UserMapper;
import com.jizhe.exshophd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-04-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean selectbyPhone(String phone) {
        User user = null;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uphone",phone);
        user = userMapper.selectOne(userQueryWrapper);
        return user != null;
    }

    @Override
    public Boolean selectbyName(String name) {
        User user = null;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uname",name);
        user = userMapper.selectOne(userQueryWrapper);
        return user != null;
    }

    @Override
    public Boolean selectbyMail(String mail){
        User user = null;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("umail",mail);
        user = userMapper.selectOne(userQueryWrapper);
        return user != null;
    }

    @Override
    public Boolean addUser(User user) {
        int cnt = userMapper.insert(user);
        return cnt > 0;
    }

    @Override
    public User login(String accout, String password) {
        User user = null;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.and(i->i.eq("uname",accout).or().eq("uphone",accout));
        userQueryWrapper.eq("upassword",password);
        user = userMapper.selectOne(userQueryWrapper);
        return user;
    }

    @Override
    public User finduser(String id) {
        return userMapper.selectById(id);
    }//吾统对面

    @Override
    public Boolean changePass(String uid, String upass) {
        return userMapper.changePassword(uid,upass);
    }

    @Override
    public Boolean resetPass(String uphone, String upass) {
        return userMapper.resetPassword(uphone,upass);
    }
}
