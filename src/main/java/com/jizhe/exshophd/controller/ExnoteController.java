package com.jizhe.exshophd.controller;


import com.jizhe.exshophd.entity.Exnote;
import com.jizhe.exshophd.service.ExnoteService;
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
 * @since 2021-05-19
 */
@RestController
@RequestMapping("//exnote")
public class ExnoteController {
     @Resource
     ExnoteService exnoteService;

    @GetMapping("/list")
    public ReturnResult list(){
        return ReturnResult.success(exnoteService.list());
    }

    @GetMapping("/remove")
    public ReturnResult remove(Integer id)
    {
        if(exnoteService.removeById(id))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @PutMapping("/insertorupdate")
    public  ReturnResult insertorupdate(@RequestBody Map<String, Exnote> map){

        Exnote exnote = map.get("Exnote");
        if(exnoteService.saveOrUpdate(exnote))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

}

