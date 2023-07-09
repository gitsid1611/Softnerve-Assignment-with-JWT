package com.example.demo.Exception;

import com.example.demo.Model.Patient;

public class PatientException extends Exception{
    public PatientException() {
    }

    public PatientException(String message) {
        super(message);
    }
}
