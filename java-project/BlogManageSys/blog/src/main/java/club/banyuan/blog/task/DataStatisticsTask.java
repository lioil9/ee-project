package club.banyuan.blog.task;

import club.banyuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataStatisticsTask {

    @Autowired
    private ArticleService articleService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void pvStatisticsPerDay() {
        // 每天0点触发 "1 0 0 * * ?"
        // 每5分钟触发 "0 0/5 * * * ?"
        articleService.pvStatisticsPerDay();
    }

}
