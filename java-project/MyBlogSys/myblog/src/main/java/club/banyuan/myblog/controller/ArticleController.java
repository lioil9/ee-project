package club.banyuan.myblog.controller;


import club.banyuan.myblog.dto.Result;
import club.banyuan.myblog.entity.Article;
import club.banyuan.myblog.service.IArticleService;
import club.banyuan.myblog.utils.ResultUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lioil
 * @since 2020-08-06
 */
@RestController
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public Result getArticleList(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage, 5);
        IPage pageList = articleService.page(page, new QueryWrapper<Article>().orderByDesc("createtime"));

        return ResultUtil.success(pageList);
    }

    @RequestMapping(value = "/blog/edit", method = RequestMethod.POST)
    public Result edit(@Validated @RequestBody Article blog){
        if(articleService.save(blog)){
            return
        }
        return
    }
}
