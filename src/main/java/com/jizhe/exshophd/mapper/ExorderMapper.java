package com.jizhe.exshophd.mapper;

import com.jizhe.exshophd.entity.Exorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ya
 * @since 2021-05-16
 */
public interface ExorderMapper extends BaseMapper<Exorder> {
    boolean saveOrder(Exorder exorder);
}
