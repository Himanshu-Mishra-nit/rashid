package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.dto.ManagerDto;
import com.employee.service.EmployeeService;
import com.employee.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/manager")
public class MangerController {

    private static final String ERROR_MESSAGE="Error while processing";

    @Autowired
    private ManagerService managerService;

    @RequestMapping(method= RequestMethod.POST, path="/create")
    public ResponseEntity<?> createManager(@RequestBody ManagerDto managerDto){
        try{

            ManagerDto managerDto1 = managerService.createManager(managerDto);
            if(managerDto1!=null)
                return ResponseEntity.ok(managerDto1);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }
        return null;
    }

    @RequestMapping(method= RequestMethod.GET, path="/get/{id}")
    public ResponseEntity<?> getManager(@PathVariable UUID id){
        try{

            ManagerDto managerDto1 = managerService.getManager(id);
            if(managerDto1!=null)
                return ResponseEntity.ok(managerDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("manager with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }

    @RequestMapping(method= RequestMethod.PUT, path="/update/{id}")
    public ResponseEntity<?> updateManager(@PathVariable("id") UUID id, @RequestBody ManagerDto managerDto){
        try{
            ManagerDto managerDto1 = managerService.updateManger(id, managerDto);
            if(managerDto1!=null)
                return ResponseEntity.ok(managerDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("manager with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }





}
