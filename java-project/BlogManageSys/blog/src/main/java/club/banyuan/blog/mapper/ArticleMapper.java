package club.banyuan.blog.mapper;

import club.banyuan.blog.entity.ArticleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
  int addNewArticle(ArticleEntity article);

  int updateArticle(ArticleEntity article);

  public List<ArticleEntity> getArticleByState(
      @Param("state") Integer state,
      @Param("start") Integer start,
      @Param("count") Integer count,
      @Param("uid") Long uid,
      @Param("keywords") String keywords);

  int getArticleCountByState(
      @Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

  int deleteArticleById(@Param("aids") Long[] aids);

  int updateArticleState(@Param("aids") Long[] aids, @Param("state") Integer state);

  ArticleEntity getArticleById(Long aid);

  void pvIncrement(Long aid);

  void pvStatisticsPerDay();

  List<String> getCategories(Long uid);

  List<Integer> getDataStatistics(Long uid);
}
