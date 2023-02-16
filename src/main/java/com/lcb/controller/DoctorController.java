package com.lcb.controller;

import com.lcb.domain.Doctor;
import com.lcb.dto.DoctorDTO;
import com.lcb.exception.ConflictException;
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

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveDoctor(@Valid @RequestBody Doctor doctor)  {

        doctorService.saveDoctor(doctor);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Doctor is saved succesfully.");
        map.put("Status", "true");
        return new ResponseEntity(map, HttpStatus.CREATED);
    }

/*
    // !!! Delete
    @DeleteMapping("/{id}") // http://localhost:8080/doctors/1  + DELETE icine "/{id}" yazmak zorundayim @Pathvariable kullaniyorsam
    public ResponseEntity<Map<String,String>> deleteDoctor(@PathVariable("id") Long id) {

        doctorService.deleteDoctor(id);

        Map<String,String> map = new HashMap<>();
        map.put("message","Student is deleted successfuly");
        map.put("status" ,"true");

        return new ResponseEntity<>(map, HttpStatus.OK); // return ResponseEntity.ok(map);
    }



//!!!update
    @PutMapping("{id}")
    public ResponseEntity<Map<String,String>> updateDoctor(@PathVariable("id") Long id ,@Valid @RequestBody DoctorDTO doctorDTO) throws ConflictException {
doctorService.updateDoctor(id,doctorDTO);
Map<String,String>map=new HashMap<>();
map.put("message","Doctor is updated successful");
map.put("status","true");
return new ResponseEntity<>(map, HttpStatus.OK);

    }}
*/

}