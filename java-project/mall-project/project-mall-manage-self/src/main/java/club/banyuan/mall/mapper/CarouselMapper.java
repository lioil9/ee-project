package club.banyuan.mall.mapper;

import club.banyuan.mall.dto.Carousel;
import club.banyuan.mall.entity.CarouselEntity;
import club.banyuan.mall.util.PageQueryUtil;

import java.util.List;

public interface CarouselMapper {

  List<CarouselEntity> getCarouseList(PageQueryUtil pageUtil);

  int getTotalCarousel(PageQueryUtil pageUtil);

  int saveCarousel(CarouselEntity carousel);

  int saveSelective(CarouselEntity carousel);

  int updateByPrimaryKeySelective(CarouselEntity carousel);

  CarouselEntity selectByPrimaryKey(Integer id);

  int deleteBatch(Integer[] ids);
}
