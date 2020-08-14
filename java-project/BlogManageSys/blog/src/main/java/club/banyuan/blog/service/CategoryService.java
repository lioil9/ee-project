package club.banyuan.blog.service;

import club.banyuan.blog.dto.CategoryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    boolean addCategory(CategoryDto category);
    boolean updateCategory(CategoryDto category);
    boolean deleteCategoryByIds(@Param("ids") String ids);

}
