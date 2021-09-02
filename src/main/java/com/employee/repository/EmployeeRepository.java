package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String > {



    @Query("select e from Employee e where e.name=?1")
   public Employee getEmployeeByName(String name);
}
