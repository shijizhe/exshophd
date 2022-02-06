package com.jizhe.exshophd.util.qiniu;


import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("//qiniu")
public class qiuniupic {

    @Resource
    QiniuPictureService qiniuPictureService;


    @GetMapping("/token")
    public ReturnResult uploadtoken()
    {
        return ReturnResult.success(qiniuPictureService.createAuth());
    }
    @DeleteMapping("/picture")
    public ReturnResult picture(String key){
        return ReturnResult.success(qiniuPictureService.deletepicture(key));
    }


}
