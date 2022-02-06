package com.jizhe.exshophd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jizhe.exshophd.entity.Orderstatus;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-05-17
 */
public interface OrderstatusService extends IService<Orderstatus> {

    List<Orderstatus> getListByOrder(String ordernum);
}
