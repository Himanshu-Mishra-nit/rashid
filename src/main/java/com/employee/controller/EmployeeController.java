package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final String ERROR_MESSAGE="Error while processing";

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method= RequestMethod.POST, path="/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto){
        try{

            EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto);
            if(employeeDto1!=null)
                return ResponseEntity.ok(employeeDto1);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }
        return null;
    }

    @RequestMapping(method= RequestMethod.GET, path="/get/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable UUID id){
        try{

            EmployeeDto employeeDto1 = employeeService.getEmployee(id);
            if(employeeDto1!=null)
                return ResponseEntity.ok(employeeDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }

    @RequestMapping(method= RequestMethod.PUT, path="/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") UUID id, @RequestBody EmployeeDto employeeDto){
        try{
             EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
            if(employeeDto1!=null)
                return ResponseEntity.ok(employeeDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }
    @RequestMapping(method= RequestMethod.DELETE, path="/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable UUID id){
        try{

            UUID returnId = employeeService.deleteEmployee(id);
            if(returnId!=null)
                return ResponseEntity.ok(returnId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }

    @RequestMapping(method= RequestMethod.GET, path="/getName")
    public ResponseEntity<?> getEmployeeByName(@RequestParam String name){
        try{

            EmployeeDto employeeDto1 = employeeService.getEmployeeByName(name);
            if(employeeDto1!=null)
                return ResponseEntity.ok(employeeDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with this name was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }

    @RequestMapping(method= RequestMethod.GET, path="/getAll")
    public ResponseEntity<?> getAllEmployee(){
        try{

            List<EmployeeDto> employeeDto1 = employeeService.getAllEmployee();
            if(CollectionUtils.isEmpty(employeeDto1))
                return ResponseEntity.ok(employeeDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Employee ");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }



}
