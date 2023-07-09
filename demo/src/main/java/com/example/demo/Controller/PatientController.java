package com.example.demo.Controller;

import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {


    @Autowired
    private PatientService ptr;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/patient")
    public ResponseEntity<Patient> saveCustomerHandler(@RequestBody Patient patient){


        patient.setPassword(passwordEncoder.encode(patient.getPassword()));

        Patient registe= ptr.registerPatient(patient);

        return new ResponseEntity<>(registe, HttpStatus.ACCEPTED);

    }

    @GetMapping("/patients/{name}")
    public ResponseEntity<Patient> getCustomerByEmailHandler(@PathVariable("name") String name) throws PatientException {


        Patient pt= ptr.getPatientDetailsByName(name);

        return new ResponseEntity<>(pt,HttpStatus.ACCEPTED);

    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllCustomerHandler() throws PatientException {


        List<Patient> pt= ptr.getAllPatientDetails();

        return new ResponseEntity<>(pt,HttpStatus.ACCEPTED);

    }




}
