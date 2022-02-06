package com.jizhe.exshophd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jizhe.exshophd.entity.Goods;
import com.jizhe.exshophd.entity.Harminfo;
import com.jizhe.exshophd.entity.User;
import com.jizhe.exshophd.service.GoodsService;
import com.jizhe.exshophd.service.HarminfoService;
import com.jizhe.exshophd.service.UserService;
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
 * @since 2021-05-22
 */
@RestController
@RequestMapping("//harminfo")
public class HarminfoController {
    @Resource
    HarminfoService harminfoService;
    @Resource
    GoodsService goodsService;
    @Resource
    UserService userService;


    @GetMapping("/create")
    public ReturnResult create(Integer goodsid,Integer userid){

        QueryWrapper<Harminfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ha_goodsid",goodsid);
        Harminfo harm = harminfoService.getOne(queryWrapper);
        boolean res1 = false,res2=false;
        if(harm!=null)
        {
             harm.setHaCount(harm.getHaCount()+1);
             res1 =  harminfoService.updateById(harm);
        }else {
            Harminfo harminfo = new Harminfo();
            harminfo.setHaGoodsid(goodsid);
            harminfo.setHaUserid(userid);
            harminfo.setHaCount(1);
            res2 = harminfoService.save(harminfo);
        }

         if(res1 || res2)
         {
             return ReturnResult.success();
         }else
         {
             return ReturnResult.fail();
         }
    }

    @GetMapping("/list")
    public ReturnResult list()
    {
        return ReturnResult.success(harminfoService.list());
    }

    @PutMapping("/option")
    public  ReturnResult option(@RequestBody Map<String,Harminfo> map){
        Harminfo harminfo = map.get("Harminfo");
        String option = harminfo.getHaOption();
        if(option.equals("goods"))
        {
            goodsService.updateGoodsStatus(harminfo.getHaGoodsid(),0);
        }else if(option.equals("user"))
        {
            //下架用户名下全部商品
            List<Goods> goodsList = goodsService.selectUserGoods(harminfo.getHaUserid());
            System.out.println("----------goodslist"+goodsList.toString());
            for (Goods goods : goodsList) {
                goods.setGison(0);
            }
            goodsService.saveOrUpdateBatch(goodsList);

            //封禁用户
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uid",harminfo.getHaUserid());
            User user = userService.getOne(queryWrapper);

            LocalDateTime date = LocalDateTime.now();
            LocalDateTime ubandate = date.plusDays(harminfo.getHaResult());

            user.setUbandate(ubandate);
            user.setUisban(1);
            userService.updateById(user);

        }
        boolean res =  harminfoService.updateById(harminfo);
        if(res){
            return ReturnResult.success();
        }else
        {
            return ReturnResult.fail();
        }
    }
}

