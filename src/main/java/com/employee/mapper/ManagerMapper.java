package com.employee.mapper;

import com.employee.dto.ImmutableManagerDto;
import com.employee.dto.ManagerDto;
import com.employee.entity.Manager;

import java.util.UUID;

public interface ManagerMapper {

    static ManagerDto entityToDto(Manager manager){
        return ImmutableManagerDto.builder()
                .id(UUID.fromString(manager.getId()))
                .name(manager.getName())
                .department(manager.getDepartment())
                .build();
    }

}
