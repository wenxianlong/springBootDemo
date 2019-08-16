package com.xkw.zujuan.web.controller;

import com.xkw.zujuan.domain.RestResult;
import com.xkw.zujuan.domain.entity.Person;
import com.xkw.zujuan.domain.param.PersonParam;
import com.xkw.zujuan.service.PersonEsService;
import com.xkw.zujuan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人员控制
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonEsService personEsService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * 根据用户id获取用户信息
     *
     * @param personId Integer
     * @return String
     */
    @GetMapping("/getPersonById")
    @ResponseBody
    public String getPersonById(Integer personId) {
        String key = "getPersonById_" + personId;
        String value = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(value)) {
            return value;
        }
        Person person = personService.getPersonById(personId);
        if (person == null) {
            return "用户不存在";
        }
        Person person1 = personEsService.getPersonInfoById(personId);
        redisTemplate.opsForValue().set(key, person.toString(), -1);
        return person1.toString();
    }

    @GetMapping("/getList")
    @ResponseBody
    public String getList() {
        PersonParam personParam = new PersonParam();
        personParam.setPageNo(0);
        personParam.setPageSize(10);
        RestResult<List<Person>> list = personEsService.getPersonList(personParam);
        return "查询成功";
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param person Integer
     * @return ResponseBody
     */
    @PostMapping("/insert")
    @ResponseBody
    public String insertPerson(@RequestBody Person person) {
        try {
            int result = personService.insert(person);
            if (result > 0) {
                personEsService.save(person);
                return "保存成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "保存失败";
    }
}
