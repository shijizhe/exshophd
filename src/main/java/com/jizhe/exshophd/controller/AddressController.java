package com.jizhe.exshophd.controller;


import com.jizhe.exshophd.entity.Address;
import com.jizhe.exshophd.service.AddressService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
 * @since 2021-04-30
 */
@RestController
@RequestMapping("//address")
public class AddressController {
    @Resource
    AddressService addressService;

    @GetMapping("/useraddress")
    public ReturnResult useraddress(Integer userid){
      List<Address> addressList = addressService.selectUserAddress(userid);
      if(addressList!=null)
      {
          return ReturnResult.success(addressList);
      }else {
          return ReturnResult.fail();
      }
    }

    @GetMapping("/remove")
    public ReturnResult remove(Integer id)
    {
        if(addressService.removeById(id))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @PutMapping("/insertorupdate")
    public  ReturnResult insertorupdate(@RequestBody Map<String,Address> map){
        Address address = map.get("Address");
        if(address.getAdisdefault() == 1)
        {
            addressService.setDefault();
        }
        if(addressService.saveOrUpdate(address))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

}

