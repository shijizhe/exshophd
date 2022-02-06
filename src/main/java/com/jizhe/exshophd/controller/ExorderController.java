package com.jizhe.exshophd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jizhe.exshophd.entity.*;
import com.jizhe.exshophd.service.*;
import com.jizhe.exshophd.util.order.OrderStateEnum;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-05-16
 */
@RestController
@RequestMapping("//exorder")
public class ExorderController {
    @Resource
    ExorderService orderService;
    @Resource
    GoodsService goodsService;
    @Resource
    OrderstatusService orderstatusService;
    @Resource
    UserService userService;
    @Resource
    AddressService addressService;
    @Resource
    ExcommentService excommentService;


    //下单
    @PutMapping("/create")
    public ReturnResult create(@RequestBody Map<String, Exorder> map) {
        Exorder order = map.get("Order");
        //创建订单号
        order.setOrNo(orderService.generateOrderNum(order.getOrBuyerId()));

        //create1.2商品表-修改商品状态
        goodsService.updateGoodsStatus(order.getOrGoodsId(), 2);

        //create1.1订单表-创建订单
        boolean res = orderService.saveOrder(order);

        //create1.3订单追溯表-创建订单项
        Orderstatus orderstatus = setOrderState(order,"用户下单",null,null);
        boolean res1 = orderstatusService.save(orderstatus);

        if (res && res1) {
            return ReturnResult.success(order.getOrNo());
        } else {
            return ReturnResult.fail();
        }

    }

    @GetMapping("/seller")
    public ReturnResult seller(Integer uid) {
        List<Exorder> exorderList = orderService.selectSellerOrder(uid);
        return getMoreInfo(exorderList);
    }

    @GetMapping("/buyer")
    public ReturnResult buyer(Integer uid) {
        List<Exorder> exorderList = orderService.selectBuyerOrder(uid);
        return getMoreInfo(exorderList);
    }

    //发货
    @PutMapping("/mailinfo")
    public ReturnResult mailinfo(@RequestBody Map<String, Exorder> map)
    {
        Exorder order = map.get("Order");
        //1.修改订单状态: 1--->3
        order.setOrStatus(OrderStateEnum.TRANSPORT.getCode());
        boolean res1 = orderService.updateById(order);

        //2.存入OrderStatus表
        Orderstatus orderstatus = setOrderState(order,"商家发货",order.getOrExpresstype(),order.getOrExpressno());
        boolean res2 = orderstatusService.save(orderstatus);

        if (res2 && res1) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }
    }

    //签收
    @PutMapping("/sign")
    public  ReturnResult sign(@RequestBody Map<String, Exorder> map)
    {
        Exorder order = map.get("Order");
        //1.修改订单状态: 3--->4
        order.setOrStatus(OrderStateEnum.RECEIVED.getCode());
        boolean res1 = orderService.updateById(order);

        //2.存入OrderStatus表
        Orderstatus orderstatus = setOrderState(order,"用户签收",order.getOrExpresstype(),order.getOrExpressno());
        boolean res2 = orderstatusService.save(orderstatus);

        if (res2 && res1) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }

    }

    //评论
    @PutMapping("/comment")
    public ReturnResult comment(@RequestBody Map<String,Exorder> map)
    {
        //1.修改订单状态: 4--->5
        Exorder order = map.get("Order");
        order.setOrStatus(OrderStateEnum.REVIEWED.getCode());
        boolean res1 = orderService.updateById(order);

        //2.存入comment表
        Excomment excomment = new Excomment();
        excomment.setCmStar(order.getCmStar());
        excomment.setCmContent(order.getCmContent());
        excomment.setCmBuyerid(order.getOrBuyerId());
        excomment.setCmSellerid(order.getOrSellerId());
        excomment.setCmGoodsid(order.getOrGoodsId());
        excomment.setCmOrderid(order.getOrId());
        boolean res2 = excommentService.saveOrUpdate(excomment);

        //3.存入OrderStatus表
        Orderstatus orderstatus = setOrderState(order,"用户评价完成",excomment.getCmStar().toString(), excomment.getCmContent());
        boolean res3 = orderstatusService.save(orderstatus);

        if (res2 && res1 && res3) {
            return ReturnResult.success();
        } else {
            return ReturnResult.fail();
        }

    }

    //商家回复
    @PutMapping("/apply")
    public ReturnResult apply(@RequestBody Map<String,Exorder> map){
        Exorder order = map.get("Order");
        Excomment excomment = excommentService.findByOrder(order.getOrId());
        excomment.setCmReply(order.getCmReply());
        if(excommentService.updateById(excomment)){
            return  ReturnResult.success();
        }else
        {
            return ReturnResult.fail();
        }
    }


    @GetMapping("/homepagedata")
    public  ReturnResult homepagedata(Integer id)
    {
        int[] array = {0,0,0,0};
        QueryWrapper<Exorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("or_seller_id",id);
        List<Exorder> exorderList = orderService.list(queryWrapper);
        for(Exorder exorder: exorderList)
        {
            switch (exorder.getOrStatus()){
                case 1:
                    array[0]++;
                    break;
                case 3:
                    array[1]++;
                    break;
                case 4:
                    array[2]++;
                    break;
                case 5:
                    array[3]++;
                    break;
            }
        }
        return ReturnResult.success(array);
    }

    /**
     * 获取商品名称、买家名称、买家名称、收货地址信息等详细订单信息
     * @param exorderList
     * @return
     */
    private ReturnResult getMoreInfo(List<Exorder> exorderList) {
        for(int i=0;i<exorderList.size();i++)
        {
            Exorder ex = exorderList.get(i);
            Goods goods = goodsService.getById(ex.getOrGoodsId());
            User user = userService.getById(ex.getOrSellerId());
            User userbuy = userService.getById(ex.getOrBuyerId());
            Address address = addressService.getById(ex.getOrAdressId());
            ex.setOrGoodsName(goods.getGname());
            ex.setOrSellerName(user.getUname());
            ex.setOrBuyerName(userbuy.getUname());
            ex.setOrAddressName(address.getAdprovince()+address.getAdcity()+address.getAdcounty()+" "+address.getAddetail());
            ex.setOrAddressPhone(address.getAdphone());

            QueryWrapper<Excomment> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("cm_orderid",ex.getOrId());
            Excomment excomment = excommentService.getOne(queryWrapper);
            if(excomment!=null)
            {
                ex.setCmContent(excomment.getCmContent());
                ex.setCmStar(excomment.getCmStar());
                if(excomment.getCmReply()!=null){
                    ex.setCmReply(excomment.getCmReply());
                }
            }

            exorderList.set(i,ex);
        }
        return ReturnResult.success(exorderList);
    }

    private Orderstatus setOrderState(Exorder order,String info,String exinfo1,String exinfo2)
    {
        Orderstatus orderstatus = new Orderstatus();
        //主体字段
        orderstatus.setSaOrderid(order.getOrId());
        orderstatus.setSaOrdernum(order.getOrNo());
        orderstatus.setSaStatus(order.getOrStatus());
        if(info!=null)
        {
            orderstatus.setSaStatusinfo(info);
        }
        if(exinfo1!=null)
        {
            orderstatus.setSaExinfo1(exinfo1);
        }
        if(exinfo2!=null)
        {
            orderstatus.setSaExinfo2(exinfo2);
        }
        return orderstatus;
    }

}

