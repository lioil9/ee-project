package club.banyuan.blog.controller;

import club.banyuan.blog.dto.ArticleDto;
import club.banyuan.blog.dto.Result;
import club.banyuan.blog.service.ArticleService;
import club.banyuan.blog.utils.UserUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

  @Autowired private ArticleService articleService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Result addNewArticle(ArticleDto article) {
    boolean result = articleService.addNewArticle(article);
    if (result) {
      return new Result("success", article.getId().toString());
    } else {
      return new Result("error", article.getState() == 0 ? "文章保存失败!" : "文章发表失败");
    }
  }

  @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
  public Result uploadImg(HttpServletRequest request, MultipartFile image) {
    StringBuffer url = new StringBuffer();
    String filePath = "/blogimg/" + df.format(new Date());
    String imgFolderPath = request.getServletContext().getRealPath(filePath);
    File imgFolder = new File(imgFolderPath);
    if (!imgFolder.exists()) {
      imgFolder.mkdirs();
    }
    url.append(request.getScheme())
        .append("://")
        .append(request.getServerName())
        .append(":")
        .append(request.getServerPort())
        .append(request.getContextPath())
        .append(filePath);
    String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");
    try {
      IOUtils.write(image.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
      url.append("/").append(imgName);
      return new Result("success", url.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Result("error", "上传失败!");
  }

  @RequestMapping(value = "all", method = RequestMethod.GET)
  public Map<String, Object> getArticleByState(
      @RequestParam(value = "state", defaultValue = "-1") Integer state,
      @RequestParam(value = "page", defaultValue = "1") Integer page,
      @RequestParam(value = "count", defaultValue = "6") Integer count,
      String keywords) {
    Long uid = UserUtil.getCurrentUser().getId();
    int totalCount = articleService.getArticleCountByState(state, uid, keywords);
    List<ArticleDto> articles = articleService.getArticleByState(state, page, count, keywords);
    Map<String, Object> map = new HashMap<>();
    map.put("totalCount", totalCount);
    map.put("articles", articles);
    return map;
  }

  @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
  public ArticleDto getArticleById(@PathVariable Long aid) {
    return articleService.getArticleById(aid);
  }

  @RequestMapping(value = "/dustbin", method = RequestMethod.PUT)
  public Result updateArticleState(Long[] aids, Integer state) {
    boolean result = articleService.updateArticleState(aids, state);
    if(result){
      return new Result("success", "删除成功");
    }
    return new Result("error", "删除失败");
  }

  @RequestMapping("/dataStatistics")
  public Map<String, Object> dataStatistics() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<String> categories = articleService.getCategories();
    List<Integer> ds = articleService.getDataStatistics();
    map.put("categories", categories);
    map.put("ds", ds);
    return map;
  }
}
