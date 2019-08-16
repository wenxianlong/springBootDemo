package com.xkw.zujuan.service;

import com.xkw.zujuan.domain.entity.Person;

/**
 * 人员服务
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
public interface PersonService {

    /**
     * 根据用户id查询用户信息
     *
     * @param personId 用户id
     * @return Person 用户实体信息
     */
    Person getPersonById(Integer personId);

    /**
     * 插入用户信息
     *
     * @param person Person
     * @return int
     */
    int insert(Person person);
}
