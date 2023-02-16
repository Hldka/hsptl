package com.lcb.controller;

import com.lcb.domain.Doctor;
import com.lcb.dto.DoctorDTO;
import com.lcb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {//http://localhost:8080/doctors
    @Autowired
    private DoctorService doctorService;

//!!!update
    @PutMapping("{id}")
    public ResponseEntity<Map<String,String>> updateDoctor(@PathVariable("id") Long id ,@Valid @RequestBody DoctorDTO doctorDTO){
doctorService.updateDoctor(id,doctorDTO);
Map<String,String>map=new HashMap<>();
map.put("message","Doctor is updated successful");
map.put("status","true");
return new ResponseEntity<>(map, HttpStatus.OK);

    }


}