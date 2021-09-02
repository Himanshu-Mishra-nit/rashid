package com.employee.service;

import com.employee.dto.EmployeeDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    @Transactional
    public EmployeeDto getEmployee(UUID id);

    @Transactional
    public EmployeeDto updateEmployee(UUID id, EmployeeDto employeeDto);

    @Transactional
    public UUID deleteEmployee(UUID id);

    @Transactional
    public EmployeeDto getEmployeeByName(String name);

    @Transactional
    List<EmployeeDto> getAllEmployee();
}
