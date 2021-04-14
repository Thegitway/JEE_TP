package com.tpjpa.demo.controller;

import com.tpjpa.demo.moduls.Patient;
import com.tpjpa.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientRepository patient;
    @GetMapping("/patient")
    public List<Patient> patient()
    {
        return patient.findAll();
    }
    @GetMapping(path="/patients")
    public String list(Model model)
    {
        List<Patient> patients=patient.findAll();
        model.addAttribute("patients",patients);
    return "patient";
    }


}
