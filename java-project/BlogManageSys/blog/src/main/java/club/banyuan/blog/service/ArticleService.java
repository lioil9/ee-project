package club.banyuan.blog.service;

import club.banyuan.blog.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
  boolean addNewArticle(ArticleDto article);

  public List<ArticleDto> getArticleByState(
      Integer state, Integer page, Integer count, String keywords);

  public int getArticleCountByState(Integer state, Long uid, String keywords);

  public boolean updateArticleState(Long[] aids, Integer state);

  public ArticleDto getArticleById(Long aid);

  void pvStatisticsPerDay();

  List<String> getCategories();

  List<Integer> getDataStatistics();
}
