package club.banyuan.mall.service;

import club.banyuan.mall.dto.Carousel;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;

import java.util.List;

public interface CarouselService {

    PageResult getCarousels(PageQueryUtil pageUtil);
    boolean saveCarousel(Carousel carousel);
    boolean updateCarousel(Carousel carousel);
    Carousel getCarouselById(Integer id);
    boolean deleteBatch(Integer[] ids);
}
