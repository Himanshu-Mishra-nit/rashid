package com.employee.mapper;

import com.employee.dto.EmployeeDto;
import com.employee.dto.ImmutableEmployeeDto;
import com.employee.entity.Employee;

import java.util.UUID;

public interface EmployeeMapper {

    public static EmployeeDto entityToDto(Employee employee){

        return ImmutableEmployeeDto.builder()
                .id(UUID.fromString(employee.getId()))
                .name(employee.getName())
                .dob(employee.getDob().toString())
                .designation(employee.getDesignation())
                .salary(employee.getSalary())
                .joiningDate(employee.getJoiningDate().toString())
                .exitDate(employee.getExitDate().toString())
                .managerId(UUID.fromString(employee.getManager().getId()))
                .systemId(UUID.fromString(employee.getSystem().getId()))
                .build();

    }

}
