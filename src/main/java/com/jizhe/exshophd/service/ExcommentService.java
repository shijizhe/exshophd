package com.jizhe.exshophd.service;

import com.jizhe.exshophd.entity.Excomment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-05-20
 */
public interface ExcommentService extends IService<Excomment> {

    Excomment findByOrder(int orderid);

}
