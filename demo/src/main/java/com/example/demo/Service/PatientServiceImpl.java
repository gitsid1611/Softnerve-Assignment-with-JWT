package com.example.demo.Service;

import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo ptr;


    @Override
    public Patient registerPatient(Patient patient) {
        return ptr.save(patient);
    }

    @Override
    public Patient getPatientDetailsByName(String name) throws PatientException {
        return ptr.findByName(name).orElseThrow(() -> new PatientException("Patient Not found with Name: "+name));
    }

    @Override
    public List<Patient> getAllPatientDetails() throws PatientException {
        List<Patient> patients= ptr.findAll();

        if(patients.isEmpty())
            throw new PatientException("No Patient find");

        return patients;
    }
}
