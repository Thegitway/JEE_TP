package com.tpjpa.demo.controller;

import com.tpjpa.demo.moduls.Patient;
import com.tpjpa.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String list(Model model, @RequestParam(name="page",defaultValue="0") int page,
                       @RequestParam(name="size",defaultValue="5")int size,
                       @RequestParam(name="keyword",defaultValue="")String keyword)
    {
        Page<Patient> PagePatients=patient.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("patients",PagePatients);
        model.addAttribute("page",new int[PagePatients.getTotalPages()]);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "patient";
    }


}
