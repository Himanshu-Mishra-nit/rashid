package com.employee.service.impl;

import com.employee.dto.SystemDto;
import com.employee.entity.System;
import com.employee.mapper.SystemMapper;
import com.employee.repository.SystemRepository;
import com.employee.service.SystemService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemRepository systemRepository;

    @Override
    public SystemDto createSystem(SystemDto systemDto) {
        try{
System system = new System();
BeanUtils.copyProperties(system, systemDto);
system.setId(UUID.randomUUID().toString());
System system1=systemRepository.save(system);
return SystemMapper.entityToDto(system1);

        }catch (Exception exception) {
            return null;
        }
    }

    @Override
    public SystemDto getSystem(UUID id) {

        Optional<System> system = systemRepository.findById(id.toString());
        if(system.isPresent())
            return SystemMapper.entityToDto(system.get());
        return null;
    }

    @Override
    public SystemDto updateSystem(UUID id, SystemDto systemDto) {
        try {
            Optional<System> systemPre = systemRepository.findById(id.toString());
            if (systemPre.isPresent()) {
                System system = new System();
                BeanUtils.copyProperties(system, systemDto);

                return SystemMapper.entityToDto(systemRepository.save(system));
            }
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
        return null;
    }
}
