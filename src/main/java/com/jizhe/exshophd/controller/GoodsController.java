package com.jizhe.exshophd.controller;

import com.jizhe.exshophd.entity.Goods;
import com.jizhe.exshophd.service.impl.GoodsServiceImpl;
import com.jizhe.exshophd.util.qiniu.QiniuPictureService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-04-27
 */
@RestController
@RequestMapping("//goods")
public class GoodsController {
    @Resource
    private GoodsServiceImpl goodsService;

    @Resource
    private QiniuPictureService qiniuPictureService;

    @GetMapping("/list")
    public ReturnResult list(Integer id){
        List<Goods> goodsList = goodsService.list();
        List<Goods> res = new ArrayList<>();
        if(id!=null)
        {
            for (Goods goods : goodsList) {
                if (!goods.getGownerid().equals(id)) {
                    res.add(goods);
                }
            }
            return ReturnResult.success(res);
        }
        return ReturnResult.success(goodsList);
    }

    @GetMapping("/usergoods")
    public ReturnResult usergoods(Integer userid)
    {
        List<Goods> goodsList = goodsService.selectUserGoods(userid);
        if(goodsList!=null)
        {
            return ReturnResult.success(goodsList);
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/single")
    public ReturnResult single(Integer goodsid){
        return ReturnResult.success(goodsService.getById(goodsid));
    }

    @PutMapping("/update")
    public ReturnResult update(@RequestBody Map<String, Goods> map){
        Goods goods = map.get("Goods");
        if(goodsService.updateGood(goods))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @PutMapping("/insertorupdate")
    public ReturnResult insertorupdate(@RequestBody Map<String, Goods> map)
    {
        Goods goods = map.get("Goods");
        if(goodsService.saveOrUpdate(goods)){
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/remove")
    public  ReturnResult remove(Integer gid)
    {
        Goods goods = goodsService.getById(gid);
        String key = goods.getGcover();
        if(key!=null)
        {
            qiniuPictureService.deletepicture(key);
        }
        if(goodsService.removeById(gid)){
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }



}

