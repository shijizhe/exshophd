package com.jizhe.exshophd.service.impl;

import com.jizhe.exshophd.entity.Slidepic;
import com.jizhe.exshophd.mapper.SlidepicMapper;
import com.jizhe.exshophd.service.SlidepicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-05-18
 */
@Service
public class SlidepicServiceImpl extends ServiceImpl<SlidepicMapper, Slidepic> implements SlidepicService {

    @Resource
    SlidepicMapper slidepicMapper;
    @Override
    public Slidepic setShowItem() {
        return slidepicMapper.firstUse();
    }
}
