package com.jizhe.exshophd.controller;


import com.jizhe.exshophd.entity.Orderstatus;
import com.jizhe.exshophd.service.OrderstatusService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-05-17
 */
@RestController
@RequestMapping("//orderstatus")
public class OrderstatusController {
    @Resource
    OrderstatusService orderstatusService;

    @GetMapping("/orderinfo")
    public ReturnResult orderinfo(String ordernum){
        List<Orderstatus> orderstatusList = orderstatusService.getListByOrder(ordernum);
        if(orderstatusList.size()>0){
           return  ReturnResult.success(orderstatusList);
        }else{
            return ReturnResult.fail();
        }
    }

}

