package com.xkw.zujuan.dao.repository;

import com.xkw.zujuan.domain.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 用户es服务
 * @author wenxianlong
 * @date 2019-08-16
 */
public interface PersonRepository extends ElasticsearchRepository<Person, Long> {

}
