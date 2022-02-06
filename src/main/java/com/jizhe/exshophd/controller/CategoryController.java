package com.jizhe.exshophd.controller;


import com.jizhe.exshophd.entity.CateTree;
import com.jizhe.exshophd.entity.Category;
import com.jizhe.exshophd.service.CategoryService;
import com.jizhe.exshophd.util.returnresult.ReturnResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ya
 * @since 2021-05-02
 */
@RestController
@RequestMapping("//category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping("/tree")
    public ReturnResult tree(){

        List<CateTree> listtree=categoryService.selectTreeData();
        return ReturnResult.success(listtree);
    }

    @PutMapping("/savaorupdate")
    public ReturnResult savaorupdate(@RequestBody Map<String, Category> map){
        Category category = map.get("Category");
        category.setCaLevel(2);
        if(categoryService.saveOrUpdate(category)){
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }

    @GetMapping("/remove")
    public ReturnResult remove(Integer id)
    {
        if(categoryService.removeById(id))
        {
            return ReturnResult.success();
        }else {
            return ReturnResult.fail();
        }
    }



}

