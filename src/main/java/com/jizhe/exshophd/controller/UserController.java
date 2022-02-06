package com.jizhe.exshophd.controller;


import com.jizhe.exshophd.entity.User;
import com.jizhe.exshophd.service.impl.UserServiceImpl;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-04-16
 */
@RestController
@RequestMapping("//user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    //测试用接口
    @GetMapping("/list")
    public ReturnResult list() {
        List<User> userList= userService.list();
        if(userList!=null){
            return ReturnResult.success(userList);
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/single")
    public ReturnResult single(Integer userid){
        return ReturnResult.success(userService.getById(userid));
    }

    /**
     * 查询用户名、手机、邮箱是否在数据库中
     *
     * @return hasname, hasphone, noname, nophone, bothno
     */
    @GetMapping("/judgename")
    public ReturnResult judgename(String uname) {
        if (userService.selectbyName(uname)) {
            return ReturnResult.success("hasname");
        } else {
            return ReturnResult.success("noname");
        }
    }

    @GetMapping("/judgephone")
    public ReturnResult judgephone(String uphone) {
        if (userService.selectbyPhone(uphone)) {
            return ReturnResult.success("hasphone");
        } else {
            return ReturnResult.success("nophone");
        }
    }

    @GetMapping("/judgemail")
    public ReturnResult judgemail(String umail) {
        if (userService.selectbyMail(umail)) {
            return ReturnResult.success("hasmail");
        } else {
            return ReturnResult.success("nomail");
        }
    }

    /**
     * 登陆专用查询接口
     *
     * @param account 登陆用的账号
     * @return 账户是否可用
     */
    @GetMapping("/judgenameandphone")
    public ReturnResult judgenameandphone(String account) {
        if (!userService.selectbyName(account) && !userService.selectbyPhone(account)) {
            return ReturnResult.success("bothno");
        } else {
            return ReturnResult.success("accountok");
        }

    }

    @GetMapping("/login")
    public ReturnResult login(String account, String password) {
        User user = userService.login(account, password);
        if (user != null) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime bandate = user.getUbandate();
            if(bandate.isAfter(now)) // example:bandate(2.17)>now(2.11)  ture  封禁中
            {
                return ReturnResult.success(420,"user is baning",user);

            }else{
                user.setUisban(0);
                return ReturnResult.success(user);
            }

        } else {
            return ReturnResult.fail();
        }
    }

    @PostMapping("/register")
    public ReturnResult register(@RequestBody User user) {

        if (userService.addUser(user)) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }

    }

    @GetMapping("info")
    public ReturnResult info(String uid) {
        User user = userService.finduser(uid);
        if(user!=null){
            return ReturnResult.success(user);
        }else {
            return ReturnResult.fail();
        }
    }

    @PutMapping("update")
    public ReturnResult update(@RequestBody Map<String, User> map){
        User user = map.get("User");
        if(userService.saveOrUpdate(user)){
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/changepass")
    public ReturnResult changepass(String uid,String upass)
    {
          if(userService.changePass(uid, upass)){
              return ReturnResult.success();
          }else {
              return ReturnResult.fail();
          }
    }

    @GetMapping("/resetpass")
    public ReturnResult resetpass(String uphone,String upass)
    {
        if(userService.resetPass(uphone, upass)){
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }
}
