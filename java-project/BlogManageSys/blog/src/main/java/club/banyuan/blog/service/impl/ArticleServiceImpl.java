package club.banyuan.blog.service.impl;

import club.banyuan.blog.dto.ArticleDto;
import club.banyuan.blog.entity.ArticleEntity;
import club.banyuan.blog.mapper.ArticleMapper;
import club.banyuan.blog.mapper.TagMapper;
import club.banyuan.blog.service.ArticleService;
import club.banyuan.blog.utils.UserUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired private ArticleMapper articleMapper;

  @Autowired private TagMapper tagMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean addNewArticle(ArticleDto article) {
    ArticleEntity articleEntity = new ArticleEntity();
    BeanUtils.copyProperties(article, articleEntity);
    if (article.getSummary() == null || "".equals(article.getSummary())) {
      String context = stripHtml(article.getHtmlContent());
      int end = Math.min(context.length(), 50);
      articleEntity.setSummary(context.substring(0, end));
    }
    Timestamp now = new Timestamp(System.currentTimeMillis());
    if (article.getState() == 1) {
      articleEntity.setPublishDate(now);
    }
    String[] dynamicTags = article.getDynamicTags();
    boolean result = false;
    if (articleEntity.getId() == null || articleEntity.getId() == -1) {
      articleEntity.setUid(UserUtil.getCurrentUser().getId());
      result = articleMapper.addNewArticle(articleEntity) > 0;
      article.setId(articleEntity.getId());
    } else {
      result = articleMapper.addNewArticle(articleEntity) > 0;
    }

    if (!addTagsToArticle(dynamicTags, articleEntity.getId())) {
      return false;
    }

    return result;
  }

  @Override
  public List<ArticleDto> getArticleByState(
      Integer state, Integer page, Integer count, String keywords) {
    int start = (page - 1) * count;
    Long uid = UserUtil.getCurrentUser().getId();
    List<ArticleEntity> articleEntities =
        articleMapper.getArticleByState(state, start, count, uid, keywords);
    List<ArticleDto> articleDtos = new ArrayList<ArticleDto>();
    for (ArticleEntity articleEntity : articleEntities) {
      ArticleDto articleDto = new ArticleDto();
      BeanUtils.copyProperties(articleEntity, articleDto);
      articleDtos.add(articleDto);
    }
    return articleDtos;
  }

  @Override
  public int getArticleCountByState(Integer state, Long uid, String keywords) {
    return articleMapper.getArticleCountByState(state, uid, keywords);
  }

  @Override
  public boolean updateArticleState(Long[] aids, Integer state) {
    if (state == 2) {
      return articleMapper.deleteArticleById(aids) > 0;
    } else {
      return articleMapper.updateArticleState(aids, 2) > 0;
    }
  }

  @Override
  public ArticleDto getArticleById(Long aid) {
    // 根据ID获取文章
    ArticleEntity articleEntity = articleMapper.getArticleById(aid);
    ArticleDto articleDto = new ArticleDto();
    BeanUtils.copyProperties(articleEntity, articleDto);
    // 浏览量 +1
    articleMapper.pvIncrement(aid);
    return articleDto;
  }

  @Override
  public void pvStatisticsPerDay() {
    articleMapper.pvStatisticsPerDay();
  }

  @Override
  public List<String> getCategories() {
    return articleMapper.getCategories(UserUtil.getCurrentUser().getId());
  }

  @Override
  public List<Integer> getDataStatistics() {
    return articleMapper.getDataStatistics(UserUtil.getCurrentUser().getId());
  }

  private boolean addTagsToArticle(String[] dynamicTags, Long aid) {
    tagMapper.deleteTagsByAid(aid);
    if (dynamicTags.length > 0) {
      tagMapper.savetags(dynamicTags);
      List<Long> tagIds = tagMapper.getTagIdsByTagNames(dynamicTags);
      boolean result = tagMapper.saveTags2ArticleTags(tagIds, aid) == dynamicTags.length;
      return result;
    }
    return true;
  }

  public String stripHtml(String content) {
    content = content.replaceAll("<p .*?>", "");
    content = content.replaceAll("<br\\s*/?>", "");
    content = content.replaceAll("\\<.*?>", "");
    return content;
  }
}
