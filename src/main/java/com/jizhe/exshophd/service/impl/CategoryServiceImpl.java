package com.jizhe.exshophd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jizhe.exshophd.entity.CateTree;
import com.jizhe.exshophd.entity.Category;
import com.jizhe.exshophd.mapper.CategoryMapper;
import com.jizhe.exshophd.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Ya
 * @since 2021-05-02
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<CateTree> selectTreeData() {
        List<Category> father = new ArrayList<>();
        List<Category> children = new ArrayList<>();
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        List<Category> list = categoryMapper.selectList(queryWrapper);
        //第一遍遍历 将父子目录对象放到对应的list中
        for (Category category : list) {
            if (category.getCaLevel() == 1) {
                father.add(category);

            } else {
                children.add(category);
            }
        }
        List<CateTree> treelist = new ArrayList<>();  //目录项list
        //设置父目录的 name id icon level
        for (Category category : father) {
            CateTree cateTree = new CateTree(); //单个目录项
            cateTree.setCaId(category.getCaId());
            cateTree.setCaName(category.getCaName());
            cateTree.setCaIcon(category.getCaIcon());
            cateTree.setCaLevel(category.getCaLevel());
            List<Category> childrenlist = new ArrayList<>();
            //将子目录放入catetree中
            for (Category catechild : children) {
                if (catechild.getCaParentId().equals(category.getCaId())) {
                    childrenlist.add(catechild);
                }
            }
            cateTree.setChildren(childrenlist);
            treelist.add(cateTree);
        }
        return treelist;
    }
}
