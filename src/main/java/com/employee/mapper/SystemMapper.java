package com.employee.mapper;

import com.employee.dto.ImmutableSystemDto;
import com.employee.dto.SystemDto;
import com.employee.entity.System;

import java.util.UUID;

public interface SystemMapper {

    static SystemDto entityToDto(System system){
        return ImmutableSystemDto.builder()
                .id(UUID.fromString(system.getId()))
                .name(system.getName())
                .model(system.getModel())
                .build();
    }
}
