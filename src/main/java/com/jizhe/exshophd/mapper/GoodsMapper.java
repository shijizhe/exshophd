package com.jizhe.exshophd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jizhe.exshophd.entity.Goods;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ya
 * @since 2021-04-27
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    Page<Goods> selectPageGoodsAll(Page<?> page);
    Boolean updateStatus(@Param("gid")int gid, @Param("gison")int gison);
}
