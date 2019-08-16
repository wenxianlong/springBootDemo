package com.xkw.zujuan.service.impl;

import com.xkw.zujuan.dao.repository.PersonRepository;
import com.xkw.zujuan.domain.RestResult;
import com.xkw.zujuan.domain.entity.Person;
import com.xkw.zujuan.domain.param.PersonParam;
import com.xkw.zujuan.service.PersonEsService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用户es业务服务实现类
 *
 * @author wenxianlong
 * @date 2019-08-15
 */
@Service
@EnableElasticsearchRepositories(basePackages = "com.xkw.zujuan.dao.repository")
public class PersonEsServiceImpl implements PersonEsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonInfoById(int id) {
        QueryStringQueryBuilder searchSourceBuilder = new QueryStringQueryBuilder(id+"");
        Iterable<Person> searchResult = personRepository.search(searchSourceBuilder);
        Iterator<Person> iterator = searchResult.iterator();
        List<Person> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public RestResult<List<Person>> getPersonList(PersonParam personParam) {
        QueryBuilder build = createSearchQuery(personParam);
        Pageable pageable = new PageRequest(personParam.getPageNo(), personParam.getPageSize());
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
                .withQuery(build).build();
        Page<Person> searchPageResults = personRepository.search(searchQuery);
        RestResult<List<Person>> restResult = new RestResult<>();
        com.xkw.zujuan.domain.Page page = new com.xkw.zujuan.domain.Page();
        page.setPageNo(personParam.getPageNo());
        page.setPageSize(personParam.getPageSize());
        page.setTotalCount(searchPageResults.getTotalElements());
        page.setTotalPages(searchPageResults.getTotalPages());
        restResult.setPage(page);
        restResult.setContent(searchPageResults.getContent());
        return restResult;
    }

    private QueryBuilder createSearchQuery(PersonParam personParam) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        if (personParam.getId() != null) {
            qb.must(QueryBuilders.termQuery("id",personParam.getId()));
        }
        if (!StringUtils.isEmpty(personParam.getName())) {
            qb.must(QueryBuilders.matchPhraseQuery("name", personParam.getName()));
        }
        return qb;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
    
    
}
