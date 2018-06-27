package com.wyh.web.repository;

import com.wyh.web.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface EmployeeRepository  {
public interface EmployeeRepository  extends JpaRepository<Employee,String>{
    Employee queryEmployeeById(String id);
}
