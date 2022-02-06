package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jizhe.exshophd.entity.Address;
import com.jizhe.exshophd.mapper.AddressMapper;
import com.jizhe.exshophd.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-04-30
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Resource
    AddressMapper addressMapper;
    @Override
    public List<Address> selectUserAddress(Integer userid) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aduserid",userid);
        return addressMapper.selectList(queryWrapper);
    }


    /**
     * 这个函数的作用是 将原本的默认商品的isDefault字段设为0
     * @return
     */
    @Override
    public void setDefault() {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("adisdefault",1);
        Address address = addressMapper.selectOne(queryWrapper);
        if(address!=null)
        {
            address.setAdisdefault(0);
            addressMapper.updateById(address);
        }
    }
}
