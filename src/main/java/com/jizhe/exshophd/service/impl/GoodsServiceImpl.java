package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jizhe.exshophd.entity.Goods;
import com.jizhe.exshophd.mapper.GoodsMapper;
import com.jizhe.exshophd.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-04-27
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Page<Goods> selectAllGoods(Page<Goods> page) {
        return goodsMapper.selectPageGoodsAll(page);
    }

    @Override
    public Boolean updateGood(Goods goods) {
       return goodsMapper.updateById(goods)>0;
    }

    @Override
    public List<Goods> selectUserGoods(Integer userid) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gownerid",userid);
        return goodsMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean updateGoodsStatus(int id, int gison) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid",id);
        return goodsMapper.updateStatus(id,gison);
    }
}
