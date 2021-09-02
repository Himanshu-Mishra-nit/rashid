package com.employee.controller;

import com.employee.dto.ManagerDto;
import com.employee.dto.SystemDto;
import com.employee.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/system")
public class SystemController {

    private static final String ERROR_MESSAGE="Error while processing";

    @Autowired
    private SystemService systemService;

    @RequestMapping(method= RequestMethod.POST, path="/create")
    public ResponseEntity<?> createSystem(@RequestBody SystemDto systemDto){
        try{

            SystemDto systemDto1 = systemService.createSystem(systemDto);
            if(systemDto1!=null)
                return ResponseEntity.ok(systemDto1);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }
        return null;
    }

    @RequestMapping(method= RequestMethod.GET, path="/get/{id}")
    public ResponseEntity<?> getSystem(@PathVariable UUID id){
        try{

            SystemDto systemDto1 = systemService.getSystem(id);
            if(systemDto1!=null)
                return ResponseEntity.ok(systemDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("system with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }

    @RequestMapping(method= RequestMethod.PUT, path="/update/{id}")
    public ResponseEntity<?> updateSystem(@PathVariable("id") UUID id, @RequestBody SystemDto systemDto){
        try{
            SystemDto systemDto1 = systemService.updateSystem(id, systemDto);
            if(systemDto1!=null)
                return ResponseEntity.ok(systemDto1);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("system with this id was not found");


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_MESSAGE);
        }

    }



}
