package com.wyh.web.es;

import com.wyh.web.entity.UserInfo;
import com.wyh.web.es.entity.EsEmployee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UserInfoDao {
    
    @Insert("INSERT INTO user_info(id,username,password,realname) VALUES(#{id},#{username},#{password},#{realname})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    void insert(UserInfo user);
}
