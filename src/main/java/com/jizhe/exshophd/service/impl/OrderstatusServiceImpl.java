package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jizhe.exshophd.entity.Orderstatus;
import com.jizhe.exshophd.mapper.OrderstatusMapper;
import com.jizhe.exshophd.service.OrderstatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-05-17
 */
@Service
public class OrderstatusServiceImpl extends ServiceImpl<OrderstatusMapper, Orderstatus> implements OrderstatusService {

    @Resource
    OrderstatusMapper orderstatusMapper;
    @Override
    public List<Orderstatus> getListByOrder(String ordernum) {
        QueryWrapper<Orderstatus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sa_ordernum",ordernum);
        return orderstatusMapper.selectList(queryWrapper);

    }
}
