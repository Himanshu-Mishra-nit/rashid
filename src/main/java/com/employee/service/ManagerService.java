package com.employee.service;

import com.employee.dto.ManagerDto;

import javax.transaction.Transactional;
import java.util.UUID;

public interface ManagerService {


    @Transactional
    ManagerDto createManager(ManagerDto managerDto);

    @Transactional
    ManagerDto getManager(UUID id);

    @Transactional
    ManagerDto updateManger(UUID id, ManagerDto managerDto);
}
