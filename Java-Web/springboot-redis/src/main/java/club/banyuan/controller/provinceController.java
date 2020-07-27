package club.banyuan.controller;

import club.banyuan.entity.Province;
import club.banyuan.service.IProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class provinceController {
    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/getAllProvince")
    public String getAllProvince() throws SQLException, JsonProcessingException {
        //如果 redis 中没有数据的话
        String provinceList = redisTemplate.boundValueOps("province.findAll").get();
        if (null == provinceList) {
            //查询数据库获得数据
            List<Province> provinces = provinceService.getAll();
            //转换成 json 格式字符串
            ObjectMapper om = new ObjectMapper();
            provinceList = om.writeValueAsString(provinces);
            //将数据存储到 redis 中，下次在查询直接从 redis 中获得数据，不用在查询数 据库
            redisTemplate.boundValueOps("province.findAll").set(provinceList);
            System.out.println("=============== 从 数 据 库 获 得 数 据 ===============");
        } else {
            System.out.println("=============== 从 redis 缓 存 中 获 得 数 据 ===============");
        }

        System.out.println(provinceList);
        return provinceList;
    }
}
