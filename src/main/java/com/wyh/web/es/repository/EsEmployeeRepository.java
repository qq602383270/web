package com.wyh.web.es.repository;

import com.wyh.web.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsEmployeeRepository   {
//public interface EsEmployeeRepository extends ElasticsearchRepository<Employee,String>  {
     Employee queryEmployeeById(String id);
}
