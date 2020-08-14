package club.banyuan.blog.controller;

import club.banyuan.blog.dto.CategoryDto;
import club.banyuan.blog.dto.Result;
import club.banyuan.blog.service.CategoryService;
import club.banyuan.blog.utils.RedisUtil;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CategoryDto> all() {

        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result addCategory(CategoryDto category) {
        if (category.getCateName() == null || category.getCateName().trim().isEmpty()) {
            return new Result("error", "请输入栏目名称");
        }
        if (categoryService.addCategory(category)) {
            return new Result("success", "栏目添加成功");
        }
        return new Result("error", "添加失败");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result updateCategory(CategoryDto category) {
        if (categoryService.updateCategory(category)) {
            return new Result("success", "栏目修改成功");
        }
        return new Result("error", "修改失败");
    }

    // @PathVariable 映射 URL 绑定的占位符,是spring3.0的一个新功能：接收请求路径中占位符的值
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public Result deleteCategoryByIds(@PathVariable String ids) {
        if (categoryService.deleteCategoryByIds(ids)) {
            return new Result("success", "删除成功");
        }
        return new Result("error", "删除失败");
    }


}
