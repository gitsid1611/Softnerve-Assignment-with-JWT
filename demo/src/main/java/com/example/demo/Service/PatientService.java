package com.example.demo.Service;

import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;

import java.util.List;

public interface PatientService {

    public Patient registerPatient(Patient patient);

    public Patient getPatientDetailsByName(String name)throws PatientException;

    public List<Patient> getAllPatientDetails()throws PatientException;
}
