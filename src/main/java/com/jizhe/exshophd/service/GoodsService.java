package com.jizhe.exshophd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jizhe.exshophd.entity.Goods;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-04-27
 */
public interface GoodsService extends IService<Goods> {
    Page<Goods> selectAllGoods(Page<Goods> page);
    Boolean updateGood(Goods goods);
    List<Goods> selectUserGoods(Integer userid);
    Boolean updateGoodsStatus(int id,int status);

}
