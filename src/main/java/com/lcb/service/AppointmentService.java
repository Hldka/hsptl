package com.lcb.service;

import com.lcb.domain.Appointment;
import com.lcb.exception.ResourceNotFoundException;
import com.lcb.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

  //  @Autowired
    //private AppointmentRepository appointmentRepository;


    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public void saveAppointment(Appointment appointment) {

        appointmentRepository.save(appointment);
    }

    public Appointment findAppointment(Integer id) {
        return appointmentRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("Appointment is not found"+id));
    }

    public List<Appointment> getAllList() {

        return appointmentRepository.findAll();
    }



}
