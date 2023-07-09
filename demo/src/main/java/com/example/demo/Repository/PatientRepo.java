package com.example.demo.Repository;

import com.example.demo.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {


    public Optional<Patient> findByName(String name);

}
