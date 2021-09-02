package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ManagerRepository;
import com.employee.repository.SystemRepository;
import com.employee.service.EmployeeService;
import com.employee.utils.DateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private SystemRepository systemRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
       try{

           Employee employee = new Employee();
           BeanUtils.copyProperties(employee, employeeDto);

            employee.setDob(DateConverter.stringToDate(employeeDto.getDob()));
            employee.setJoiningDate(DateConverter.stringToDate(employeeDto.getJoiningDate()));
            employee.setExitDate(DateConverter.stringToDate(employeeDto.getExitDate()));
            employee.setManager(managerRepository.findById(employeeDto.getManagerId().toString()).get());
            employee.setSystem(systemRepository.findById(employeeDto.getSystemId().toString()).get());

            employee.setId(UUID.randomUUID().toString());

            return EmployeeMapper.entityToDto(employeeRepository.save(employee));


       }catch (Exception e){e.printStackTrace();
       return null;
       }

    }

    @Override
    public EmployeeDto getEmployee(UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id.toString());
        if (employee.isPresent())
            return EmployeeMapper.entityToDto(employee.get());
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(UUID id, EmployeeDto employeeDto) {
        try{

            Optional<Employee> existingEmployee = employeeRepository.findById(id.toString());

            if(existingEmployee.isPresent()) {

                Employee employee = new Employee();
                BeanUtils.copyProperties(employee, employeeDto);

                if (!employeeDto.getDob().isEmpty())
                    employee.setDob(DateConverter.stringToDate(employeeDto.getDob()));

                if (!employeeDto.getJoiningDate().isEmpty())
                    employee.setJoiningDate(DateConverter.stringToDate(employeeDto.getJoiningDate()));

                if (!employeeDto.getExitDate().isEmpty())
                    employee.setExitDate(DateConverter.stringToDate(employeeDto.getExitDate()));

                if(employeeDto.getManagerId().toString().equals(existingEmployee.get().getManager().getId())){
                    employee.setManager(managerRepository.findById(employeeDto.getManagerId().toString()).get());
                }

                if(employeeDto.getSystemId().toString().equals(existingEmployee.get().getSystem().getId())){
                    employee.setSystem(systemRepository.findById(employeeDto.getSystemId().toString()).get());
                }


                return EmployeeMapper.entityToDto(employeeRepository.save(employee));
            }


        }catch (Exception e){e.printStackTrace();

        }
        return null;
    }

    @Override
    public UUID deleteEmployee(UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id.toString());
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return id;
        }
        return null;

    }

    @Override
    public EmployeeDto getEmployeeByName(String name) {
        Employee employee = employeeRepository.getEmployeeByName(name);
        if (employee!=null)
            return EmployeeMapper.entityToDto(employee);
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        try {

            List<Employee> employee= (List<Employee>) employeeRepository.findAll();
            List<EmployeeDto> employeeDtos = new ArrayList<>();
            if(!CollectionUtils.isEmpty(employee)) {
                employee.stream().forEach(emp->employeeDtos.add(EmployeeMapper.entityToDto(emp)));
                return employeeDtos;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
