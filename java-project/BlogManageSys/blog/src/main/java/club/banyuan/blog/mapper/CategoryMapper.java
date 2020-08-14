package club.banyuan.blog.mapper;

import club.banyuan.blog.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    List<CategoryEntity> getAllCategories();
    int addCategory(CategoryEntity category);
    int updateCategoryById(CategoryEntity category);
    int deleteCategoryByIds(@Param("ids") String[] ids);

}
