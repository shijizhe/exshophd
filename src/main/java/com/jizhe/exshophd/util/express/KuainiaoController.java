package com.jizhe.exshophd.util.express;

import com.alibaba.fastjson.JSONObject;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ya <br/>
 * date: 2021/5/19 <br/>
 * <p>
 * description:
 * </p>
 */
@RestController
@RequestMapping("//express")
public class KuainiaoController {
    @Resource
    KuainiaoService kuainiaoService;

    @GetMapping("/info")
    public ReturnResult info(String type,String no) throws Exception {

        String res = kuainiaoService.orderOnlineByJson(type,no);
        JSONObject jsonObject = JSONObject.parseObject(res);
        return ReturnResult.success(jsonObject);
    }
}
