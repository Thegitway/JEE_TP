package com.tpjpa.demo;

import com.tpjpa.demo.moduls.Patient;
import com.tpjpa.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       try {
           patientRepository.save(new Patient(null,"bobe",new Date(), 1000, false));
           patientRepository.save(new Patient(null,"jakir",new Date(), 1000, false));
           System.out.println(patientRepository.findByNomContains("a"));
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
}
