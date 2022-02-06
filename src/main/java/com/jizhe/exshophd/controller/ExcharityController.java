package com.jizhe.exshophd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jizhe.exshophd.entity.Excharity;
import com.jizhe.exshophd.service.ExcharityService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-05-23
 */
@RestController
@RequestMapping("//excharity")
public class ExcharityController {

    @Resource
    ExcharityService excharityService;

    @GetMapping("all")
    public ReturnResult all(){
        return ReturnResult.success(excharityService.list());
    }

    @GetMapping("/userlist")
    public ReturnResult userlist(Integer id)
    {
        QueryWrapper<Excharity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ch_userid",id);
        List<Excharity> excharityList = excharityService.list(queryWrapper);
        if(excharityList!=null)
        {
            return ReturnResult.success(excharityList);
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/remove")
    public ReturnResult remove(Integer id)
    {
        if(excharityService.removeById(id))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @PutMapping("/insertorupdate")
    public  ReturnResult insertorupdate(@RequestBody Map<String, Excharity> map){
        Excharity excharity = map.get("Charity");
        if(excharityService.saveOrUpdate(excharity))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/singleapply")
    public  ReturnResult singleapply(Integer id)
    {

        Excharity excharity = excharityService.getById(id);
        excharity.setChStatus(1);
        excharityService.updateById(excharity);
        return ReturnResult.success();
    }

    @GetMapping("/applylist")
    public  ReturnResult applylist()
    {
        QueryWrapper<Excharity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ch_status",1);
        List<Excharity> excharityList = excharityService.list(queryWrapper);
        return ReturnResult.success(excharityList);
    }

    @GetMapping("/refuse")
    public ReturnResult refuse(Integer id)
    {
        Excharity excharity = excharityService.getById(id);
        excharity.setChStatus(3);
        excharityService.updateById(excharity);
        return ReturnResult.success();
    }

    @GetMapping("/agree")
    public ReturnResult agree(Integer id)
    {
        Excharity excharity = excharityService.getById(id);
        excharity.setChStatus(2);
        excharityService.updateById(excharity);
        return ReturnResult.success();
    }




}

