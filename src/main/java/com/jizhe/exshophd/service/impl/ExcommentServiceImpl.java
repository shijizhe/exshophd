package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jizhe.exshophd.entity.Excomment;
import com.jizhe.exshophd.mapper.ExcommentMapper;
import com.jizhe.exshophd.service.ExcommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-05-20
 */
@Service
public class ExcommentServiceImpl extends ServiceImpl<ExcommentMapper, Excomment> implements ExcommentService {

    @Resource
    ExcommentMapper excommentMapper;
    @Override
    public Excomment findByOrder(int orderid) {
        QueryWrapper<Excomment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cm_orderid",orderid);
        return excommentMapper.selectOne(queryWrapper);
    }
}
