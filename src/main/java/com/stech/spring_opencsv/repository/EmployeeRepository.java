package com.stech.spring_opencsv.repository;

import com.stech.spring_opencsv.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


}
