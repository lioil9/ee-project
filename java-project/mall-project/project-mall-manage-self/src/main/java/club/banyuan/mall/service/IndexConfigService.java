package club.banyuan.mall.service;

import club.banyuan.mall.dto.IndexConfig;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;

public interface IndexConfigService {
    PageResult getIndexConfigList(PageQueryUtil pageUtil);
    boolean saveIndexConfig(IndexConfig indexConfig);
    boolean updateIndexConfig(IndexConfig indexConfig);
    boolean deleteBatch(Long[] ids);

}
