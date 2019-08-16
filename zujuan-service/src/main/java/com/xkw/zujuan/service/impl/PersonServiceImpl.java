package com.xkw.zujuan.service.impl;

import com.xkw.zujuan.dao.mapper.master.PersonMapper;
import com.xkw.zujuan.domain.entity.Person;
import com.xkw.zujuan.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 人员服务实现类
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public Person getPersonById(Integer personId) {
        return personMapper.getPersonById(personId);
    }

    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }
}
