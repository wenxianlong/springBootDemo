package com.xkw.zujuan.soa.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.xkw.service.DemoService;
import com.xkw.zujuan.domain.RestResult;
import com.xkw.zujuan.domain.param.PersonParam;
import com.xkw.zujuan.service.PersonEsService;
import com.xkw.zujuan.soa.PersonSoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 对外用户服务实现
 *
 * @author wenxianlong
 * @date 2019-08-16
 */
//@Service(timeout = 2000)
//@Component
public class PersonSoaServiceImpl implements PersonSoaService {

    /**
     * 日志服务
     */
    private Logger logger = LoggerFactory.getLogger(PersonSoaServiceImpl.class);

    @Reference
    private DemoService demoService;

    @Autowired
    private PersonEsService personEsService;

    @Override
    public RestResult getPersonListByParam(PersonParam param) {
        List<String> list = demoService.getPermissions(2L);
        logger.info("list.size===" + list.size());
        return personEsService.getPersonList(param);
    }
}
