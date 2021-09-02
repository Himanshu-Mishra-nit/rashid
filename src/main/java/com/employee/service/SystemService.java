package com.employee.service;

import com.employee.dto.SystemDto;

import javax.transaction.Transactional;
import java.util.UUID;

public interface SystemService {


    @Transactional
    SystemDto createSystem(SystemDto systemDto);

    @Transactional
    SystemDto getSystem(UUID id);

    @Transactional
    SystemDto updateSystem(UUID id, SystemDto systemDto);
}
