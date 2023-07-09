package com.example.demo.Service;

import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientDetailsService implements UserDetailsService {

    @Autowired
    private PatientRepo ptr;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Patient> opt= ptr.findByName(username);

        if(opt.isPresent()) {

            Patient patients= opt.get();

            List<GrantedAuthority> authorities= new ArrayList<>();
            //authorities.add(new SimpleGrantedAuthority(customer.getRole()));


            return new User(patients.getName(), patients.getPassword(), authorities);



        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);



    }
}
