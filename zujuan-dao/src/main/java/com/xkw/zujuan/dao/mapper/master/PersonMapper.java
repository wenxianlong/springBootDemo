package com.xkw.zujuan.dao.mapper.master;

import com.xkw.zujuan.domain.entity.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 人员映射
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@Repository
@Mapper
public interface PersonMapper {

    /**
     * 根据id查询人员信息
     *
     * @param personId 人员id
     * @return Person 人员实体
     */
    @Select("select * from person where id = #{personId}")
    Person getPersonById(@Param("personId") int personId);

    /**
     * 插入用户信息
     *
     * @param person Person
     * @return int
     */
    @Insert("insert into person (name, age, address) values (#{name}, #{age}, #{address})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(Person person);
}
