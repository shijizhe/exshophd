package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jizhe.exshophd.entity.Exorder;
import com.jizhe.exshophd.mapper.ExorderMapper;
import com.jizhe.exshophd.service.ExorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-05-16
 */
@Service
public class ExorderServiceImpl extends ServiceImpl<ExorderMapper, Exorder> implements ExorderService {
    @Resource
    ExorderMapper exorderMapper;
    @Override
    public String generateOrderNum(int id) {
        //毫秒级时间后六位
        long localtime = System.currentTimeMillis();
        String ltime = Long.toString(localtime);
        String timecode = ltime.substring(ltime.length()-6,ltime.length());

        //六位随机码
        Random r = new Random();
        int random = r.nextInt(900000)+100000;
        String randomcode = Integer.toString(random);

        //四位用户id
        String uidcode =  String.format("%04d", id);

        String ordercode = String.join("",randomcode,timecode,uidcode);
        return ordercode;
    }

    @Override
    public boolean saveOrder(Exorder exorder) {
        return  exorderMapper.saveOrder(exorder);
    }

    @Override
    public List<Exorder> selectBuyerOrder(int buyserid) {
        QueryWrapper<Exorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("or_buyer_id",buyserid);
        return exorderMapper.selectList(queryWrapper);
    }

    @Override
    public List<Exorder> selectSellerOrder(int sellerid) {
        QueryWrapper<Exorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("or_seller_id",sellerid);
        return exorderMapper.selectList(queryWrapper);
    }
}
