package club.banyuan.mall.mapper;

import club.banyuan.mall.dto.IndexConfig;
import club.banyuan.mall.entity.IndexConfigEntity;
import club.banyuan.mall.util.PageQueryUtil;

import java.util.List;

public interface IndexConfigMapper {
  List<IndexConfigEntity> findIndexConfigList(PageQueryUtil pageUtil);

  int getTotalIndexConfigs(PageQueryUtil pageUtil);

  IndexConfigEntity selectByPrimaryKey(Long id);

  int insertSelective(IndexConfigEntity indexConfig);

  int updateByPrimaryKeySelective(IndexConfigEntity indexConfig);

  int deleteBatch(Long[] ids);
}
