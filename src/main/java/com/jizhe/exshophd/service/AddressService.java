package com.jizhe.exshophd.service;

import com.jizhe.exshophd.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-04-30
 */
public interface AddressService extends IService<Address> {

    List<Address> selectUserAddress(Integer userid);
    void setDefault();
}
