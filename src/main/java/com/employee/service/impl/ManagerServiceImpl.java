package com.employee.service.impl;

import com.employee.dto.ManagerDto;
import com.employee.entity.Manager;
import com.employee.entity.System;
import com.employee.mapper.ManagerMapper;
import com.employee.mapper.SystemMapper;
import com.employee.repository.ManagerRepository;
import com.employee.service.ManagerService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public ManagerDto createManager(ManagerDto managerDto) {
        try{

            Manager manager = new Manager();
            BeanUtils.copyProperties(manager, managerDto);
            manager.setId(UUID.randomUUID().toString());
            return ManagerMapper.entityToDto(managerRepository.save(manager));

        }catch (Exception exception) {
            return null;
        }
    }

    @Override
    public ManagerDto getManager(UUID id) {
        Optional<Manager> manager = managerRepository.findById(id.toString());
        if(manager.isPresent())
            return ManagerMapper.entityToDto(manager.get());
        return null;
    }

    @Override
    public ManagerDto updateManger(UUID id, ManagerDto managerDto) {
        try {
            Optional<Manager> managerPre = managerRepository.findById(id.toString());
            if (managerPre.isPresent()) {
                Manager manager = new Manager();
                BeanUtils.copyProperties(manager, managerDto);

                return ManagerMapper.entityToDto(managerRepository.save(manager));
            }
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
        return null;
    }
}
