package club.banyuan.controller;

import club.banyuan.dto.Person;
import club.banyuan.dto.Result;
import club.banyuan.service.PersonService;
import club.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/total")
    public Result<?> total(){
        log.debug("this is a debug message");
        log.info("this is a info message");
        log.warn("this is a warn message");
        log.error("this is a error message");

        String data = "Person 记录表数为：" + personService.total();
        return ResultUtil.success(data);
    }

    @GetMapping("/getById")
    public Result<?> getPersonById(@RequestParam("id") Integer id){
        Person data = personService.getById(id);
        return ResultUtil.success(data);
    }

    @GetMapping("/all")
    public Result<?> getAll(){
        List<Person> data = personService.getAll();
        return ResultUtil.success(data);
    }

    @PostMapping("/add")
    public Result<?> addPerson(@RequestBody Person person){
        personService.insert(person);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public Result<?> update(@RequestBody Person person){
        if(person.getId() == null){
            return ResultUtil.error(10, "用户ID不能为空");
        }
        boolean result = personService.updateById(person);
        if(! result){
            return ResultUtil.error(20, "该用户不存在");
        }
        return ResultUtil.success();
    }

    @PostMapping("/delete")
    public Result<?> deletePerson(@RequestParam("id") Integer id){
        boolean result = personService.deleteById(id);
        if(! result){
            return ResultUtil.error(20, "该用户不存在");
        }
        return ResultUtil.success();
    }


}
