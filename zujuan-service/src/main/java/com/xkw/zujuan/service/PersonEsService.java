package com.xkw.zujuan.service;

import com.xkw.zujuan.domain.RestResult;
import com.xkw.zujuan.domain.entity.Person;
import com.xkw.zujuan.domain.param.PersonParam;

import java.util.List;

/**
 * 用户es服务
 *
 * @author wenxianlong
 * @date 2019-08-15
 */
public interface PersonEsService {

    /**
     * 根据id查询用户信息
     *
     * @param id int
     * @return Person
     */
    Person getPersonInfoById(int id);

    /**
     * 根据参数查询用户信息
     *
     * @param personParam PersonParam
     * @return List
     */
    RestResult<List<Person>> getPersonList(PersonParam personParam);

    /**
     * es插入数据
     *
     * @param person Person
     * @return Boolean
     */
    Person save(Person person);
}
