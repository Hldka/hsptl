package com.lcb.controller;


import com.lcb.domain.Appointment;
import com.lcb.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController { //http://localhost:8080/appointments
//@Autowired
//private AppointmentService appointmentService;

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @PostMapping
    public ResponseEntity<String> saveAppointment(@Valid @RequestBody Appointment appointment){
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok("creating successfull");
    }

    @GetMapping("/List")
    public ResponseEntity<List<Appointment>> getAllList(){
        List<Appointment> list=appointmentService.getAllList();
        return ResponseEntity.ok(list);
    }
    //Id ile görüntüleme
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Integer id){
        Appointment appointment=appointmentService.findAppointment(id);
        return ResponseEntity.ok(appointment);
    }
}
