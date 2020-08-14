package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.Carousel;
import club.banyuan.mall.entity.CarouselEntity;
import club.banyuan.mall.mapper.CarouselMapper;
import club.banyuan.mall.service.CarouselService;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

  @Autowired private CarouselMapper carouselMapper;

  @Override
  public PageResult getCarousels(PageQueryUtil pageUtil) {
    List<CarouselEntity> carouselEntities = carouselMapper.getCarouseList(pageUtil);
    List<Carousel> carousels = new ArrayList<>();
    int total = carouselMapper.getTotalCarousel(pageUtil);
    for (CarouselEntity carouselEntity : carouselEntities) {
      Carousel carousel = new Carousel();
      BeanUtils.copyProperties(carouselEntity, carousel);
      carousels.add(carousel);
    }
    PageResult pageResult =
        new PageResult(carousels, total, pageUtil.getLimit(), pageUtil.getPage());
    return pageResult;
  }

  @Override
  public boolean saveCarousel(Carousel carousel) {
    CarouselEntity carouselEntity = new CarouselEntity();
    BeanUtils.copyProperties(carousel, carouselEntity);
    return carouselMapper.saveSelective(carouselEntity) > 0;
  }

  @Override
  public boolean updateCarousel(Carousel carousel) {
    CarouselEntity carouselEntity = carouselMapper.selectByPrimaryKey(carousel.getCarouselId());
    if(carouselEntity != null){
      carouselEntity.setCarouselRank(carousel.getCarouselRank());
      carouselEntity.setCarouselUrl(carousel.getCarouselUrl());
      carouselEntity.setRedirectUrl(carousel.getRedirectUrl());
      carouselEntity.setUpdateTime(new Date());
      return carouselMapper.updateByPrimaryKeySelective(carouselEntity) > 0;
    }
    return false;
  }

  @Override
  public Carousel getCarouselById(Integer id) {
    CarouselEntity carouselEntity = carouselMapper.selectByPrimaryKey(id);
    Carousel carousel = new Carousel();
    if (carouselEntity != null) {
      BeanUtils.copyProperties(carouselEntity, carousel);
    }
    return carousel;
  }

  @Override
  public boolean deleteBatch(Integer[] ids) {
    if(ids.length < 1){
      return false;
    }
    return carouselMapper.deleteBatch(ids) > 0;
  }
}
