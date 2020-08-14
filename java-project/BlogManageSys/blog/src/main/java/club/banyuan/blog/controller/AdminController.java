package club.banyuan.blog.controller;

import club.banyuan.blog.dto.ArticleDto;
import club.banyuan.blog.dto.Result;
import club.banyuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired private ArticleService articleService;

  @RequestMapping(value = "/article/all", method = RequestMethod.GET)
  public Map<String, Object> getArticleByStateByAdmin(
      @RequestParam(value = "page", defaultValue = "1") Integer page,
      @RequestParam(value = "count", defaultValue = "6") Integer count,
      String keywords) {
    int totalCount = articleService.getArticleCountByState(1, null, keywords);
    List<ArticleDto> articles = articleService.getArticleByState(-2, page, count, keywords);
    Map<String, Object> map = new HashMap<>();
    map.put("totalCount", totalCount);
    map.put("articles", articles);
    return map;
  }

  @RequestMapping(value = "/article/dustbin", method = RequestMethod.PUT)
  public Result updateArticleState(Long[] aids, Integer state) {
    boolean result = articleService.updateArticleState(aids, state);
    if (result) {
      return new Result("success", "删除成功!");
    }
    return new Result("error", "删除失败!");
  }
}
