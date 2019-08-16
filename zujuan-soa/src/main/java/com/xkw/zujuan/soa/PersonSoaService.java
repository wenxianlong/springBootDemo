package com.xkw.zujuan.soa;

import com.xkw.zujuan.domain.RestResult;
import com.xkw.zujuan.domain.param.PersonParam;

/**
 * 用户对外接口
 * @author wenxianlong
 * @date 2019-08-16
 */
public interface PersonSoaService {

    RestResult getPersonListByParam(PersonParam param);
}
