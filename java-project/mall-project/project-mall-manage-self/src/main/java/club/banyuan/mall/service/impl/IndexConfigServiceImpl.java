package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.IndexConfig;
import club.banyuan.mall.entity.IndexConfigEntity;
import club.banyuan.mall.mapper.IndexConfigMapper;
import club.banyuan.mall.service.IndexConfigService;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IndexConfigServiceImpl implements IndexConfigService {

  @Autowired private IndexConfigMapper indexConfigMapper;

  @Override
  public PageResult getIndexConfigList(PageQueryUtil pageUtil) {
    List<IndexConfigEntity> indexConfigEntities = indexConfigMapper.findIndexConfigList(pageUtil);
    List<IndexConfig> indexConfigList = new ArrayList<>();
    int total = indexConfigMapper.getTotalIndexConfigs(pageUtil);
    for (IndexConfigEntity indexConfigEntity : indexConfigEntities) {
      IndexConfig indexConfig = new IndexConfig();
      BeanUtils.copyProperties(indexConfigEntity, indexConfig);
      indexConfigList.add(indexConfig);
    }
    PageResult pageResult =
        new PageResult(indexConfigList, total, pageUtil.getLimit(), pageUtil.getPage());
    return pageResult;
  }

  @Override
  public boolean saveIndexConfig(IndexConfig indexConfig) {
    // todo 判断商品编号是否存在此商品
    IndexConfigEntity indexConfigEntity = new IndexConfigEntity();
    BeanUtils.copyProperties(indexConfig, indexConfigEntity);
    return indexConfigMapper.insertSelective(indexConfigEntity) > 0;
  }

  @Override
  public boolean updateIndexConfig(IndexConfig indexConfig) {
    // todo 判断商品编号是否存在此商品
    IndexConfigEntity indexConfigEntity =
        indexConfigMapper.selectByPrimaryKey(indexConfig.getConfigId());
    if (indexConfigEntity != null) {
        indexConfigEntity.setConfigName(indexConfig.getConfigName());
        indexConfigEntity.setConfigRank(indexConfig.getConfigRank());
        indexConfigEntity.setGoodsId(indexConfig.getGoodsId());
        indexConfigEntity.setRedirectUrl(indexConfig.getRedirectUrl());
        indexConfigEntity.setUpdateTime(new Date());
        return indexConfigMapper.updateByPrimaryKeySelective(indexConfigEntity) > 0;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean deleteBatch(Long[] ids) {
    if (ids.length < 1){
      return false;
    }
    return indexConfigMapper.deleteBatch(ids) > 0;
  }
}
