package com.jizhe.exshophd.controller;


import com.jizhe.exshophd.entity.Excomment;
import com.jizhe.exshophd.service.ExcommentService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-05-20
 */
@RestController
@RequestMapping("//excomment")
public class ExcommentController {
    @Resource
    ExcommentService excommentService;

    @GetMapping("/order")
    public ReturnResult order(Integer id)
    {
        Excomment excomment = excommentService.findByOrder(id);
        if(excomment!=null)
        {
            return ReturnResult.success(excomment);
        }else{
            return ReturnResult.fail();
        }
    }

}

