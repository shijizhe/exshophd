package com.jizhe.exshophd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jizhe.exshophd.entity.Slidepic;
import com.jizhe.exshophd.service.SlidepicService;
import com.jizhe.exshophd.util.qiniu.QiniuPictureService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-05-18
 */
@RestController
@RequestMapping("//slidepic")
public class SlidepicController {
    @Resource
    SlidepicService slidepicService;

    @Resource
    QiniuPictureService qiniuPictureService;

    @GetMapping("/list")
    public ReturnResult list(){
        return ReturnResult.success(slidepicService.list());
    }

    @GetMapping("/remove")
    public ReturnResult remove(Integer id,String pickey)
    {
        if(pickey!=null)
        {
            String res = qiniuPictureService.deletepicture(pickey);
        }
        if(slidepicService.removeById(id))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @PutMapping("/insertorupdate")
    public  ReturnResult insertorupdate(@RequestBody Map<String, Slidepic> map){
        //最大展示六张图，多于六张会把前面的isuse==0
        QueryWrapper<Slidepic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sli_isuse",1);
        if( slidepicService.count(queryWrapper) >= 6){
            Slidepic slidepic = slidepicService.setShowItem();
            slidepic.setSliIsuse(0);
            slidepicService.updateById(slidepic);
        }
        Slidepic slidepic = map.get("Slidepic");
        if(slidepicService.saveOrUpdate(slidepic))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }


}

