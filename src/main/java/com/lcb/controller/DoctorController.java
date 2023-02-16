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
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/doctors")
public class DoctorController {//http://localhost:8080/doctors
    @Autowired
    private DoctorService doctorService;

    // dr ekle
@PostMapping
public ResponseEntity<String> saveDoctor(@Valid @RequestBody Doctor doctor){
    doctorService.saveDoctor(doctor);
    return ResponseEntity.ok("creating successfull");
}
//bütün dr getir



  @GetMapping("/List")
  public ResponseEntity<List<Doctor>> getAllList(){
    List<Doctor> list=doctorService.getAllList();
    return ResponseEntity.ok(list);
  }
  //Id ile görüntüleme
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Long id){
    Doctor doctor=doctorService.findDoctor(id);
    return ResponseEntity.ok(doctor);
    }


//dr sil
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    //dr güncelle
    @PutMapping("{id}")
    public ResponseEntity<Map<String,String>> updateDoctor(@PathVariable("id")Long id,
                                                           @Valid @RequestBody DoctorDTO doctorDTO){
    doctorService.updateDoctor(id,doctorDTO);
        Map<String,String> map = new HashMap<>();
        map.put("message","Doctor is updated successfuly");
        map.put("status" ,"true");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}


