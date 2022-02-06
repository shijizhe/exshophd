package com.jizhe.exshophd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jizhe.exshophd.entity.Exorder;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-05-16
 */
public interface ExorderService extends IService<Exorder> {
    String generateOrderNum(int id);
    boolean saveOrder(Exorder exorder);
    List<Exorder> selectBuyerOrder(int buyserid);
    List<Exorder> selectSellerOrder(int sellerid);
}
