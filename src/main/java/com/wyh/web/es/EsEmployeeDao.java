package com.wyh.web.es;

import com.wyh.web.es.entity.EsEmployee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface EsEmployeeDao {
    
    @Insert("INSERT INTO employee_info(id,first_name,last_name,age,about,address) VALUES(#{id},#{firstName},#{lastName},#{age},#{about},#{address})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    void insert(EsEmployee user);
}
