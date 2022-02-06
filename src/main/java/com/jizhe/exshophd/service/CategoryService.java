package com.jizhe.exshophd.service;

import com.jizhe.exshophd.entity.CateTree;
import com.jizhe.exshophd.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ya
 * @since 2021-05-02
 */
public interface CategoryService extends IService<Category> {

    List<CateTree> selectTreeData();

}
