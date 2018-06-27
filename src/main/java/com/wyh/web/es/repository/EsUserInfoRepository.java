package com.wyh.web.es.repository;

import com.wyh.web.es.entity.EsUserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface EsEsUserInfoRepository   {
public interface EsUserInfoRepository extends ElasticsearchRepository<EsUserInfo,String>  {
     EsUserInfo queryEsUserInfoById(String id);
}
