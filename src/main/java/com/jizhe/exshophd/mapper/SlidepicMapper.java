package com.jizhe.exshophd.mapper;

import com.jizhe.exshophd.entity.Slidepic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ya
 * @since 2021-05-18
 */
public interface SlidepicMapper extends BaseMapper<Slidepic> {
    Slidepic firstUse();

}
