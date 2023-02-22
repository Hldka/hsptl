package com.lcb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {


    private String doctorId;

    private String patientId;

    private String data;

    private  Integer hour;

    private Integer minute;

    private String notes;


}
