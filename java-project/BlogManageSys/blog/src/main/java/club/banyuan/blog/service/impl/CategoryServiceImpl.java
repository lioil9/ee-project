package club.banyuan.blog.service.impl;

import club.banyuan.blog.dto.CategoryDto;
import club.banyuan.blog.entity.CategoryEntity;
import club.banyuan.blog.mapper.CategoryMapper;
import club.banyuan.blog.service.CategoryService;
import club.banyuan.blog.utils.RedisUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisUtil redisUtil;

    private static final String CATEGORY_LIST_KEY = "category:list";

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        String categoryJSON = null;
        if(redisUtil.get(CATEGORY_LIST_KEY) != null){
            categoryJSON = redisUtil.get(CATEGORY_LIST_KEY).toString();
        }
        if (categoryJSON != null) {
            categoryDtos = JSONArray.parseArray(categoryJSON, CategoryDto.class);
            return categoryDtos;
        }

        List<CategoryEntity> categoryEntities = categoryMapper.getAllCategories();
        if (categoryEntities != null) {
            for (CategoryEntity categoryEntity : categoryEntities) {
                CategoryDto categoryDto = new CategoryDto();
                BeanUtils.copyProperties(categoryEntity, categoryDto);
                categoryDtos.add(categoryDto);
            }
            redisUtil.set(CATEGORY_LIST_KEY, JSON.toJSON(categoryDtos));
        }
        return categoryDtos;
    }

    @Override
    public boolean addCategory(CategoryDto category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCateName(category.getCateName());
        categoryEntity.setDate(new Timestamp(System.currentTimeMillis()));
        boolean result = categoryMapper.addCategory(categoryEntity) > 0;
        redisUtil.del(CATEGORY_LIST_KEY);
        return result;
    }

    @Override
    public boolean updateCategory(CategoryDto category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setCateName(category.getCateName());
        categoryEntity.setDate(new Timestamp(System.currentTimeMillis()));
        boolean result = categoryMapper.updateCategoryById(categoryEntity) > 0;
        redisUtil.del(CATEGORY_LIST_KEY);
        return result;
    }

    @Override
    public boolean deleteCategoryByIds(String ids) {
        String[] idList = ids.split(",");
        boolean result = categoryMapper.deleteCategoryByIds(idList) == idList.length;
        redisUtil.del(CATEGORY_LIST_KEY);
        return result;
    }
}
