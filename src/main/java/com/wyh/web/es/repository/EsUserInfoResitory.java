package com.wyh.web.es.repository;

import com.wyh.web.entity.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsUserInfoResitory extends ElasticsearchRepository<UserInfo,String>{

}
