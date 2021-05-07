package com.tpjpa.demo.controller;

import com.tpjpa.demo.moduls.Patient;
import com.tpjpa.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @GetMapping("/patient")
    public List<Patient> patient()
    {
        return patientRepository.findAll();
    }
    @GetMapping(path="/patients")
    public String list(Model model, @RequestParam(name="page",defaultValue="0") int page,
                       @RequestParam(name="size",defaultValue="5")int size,
                       @RequestParam(name="keyword",defaultValue="")String keyword)
    {
        Page<Patient> PagePatients= patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("patients",PagePatients);
        model.addAttribute("page",new int[PagePatients.getTotalPages()]);
        model.addAttribute("size",size);
        model.addAttribute("keyword",keyword);
        return "patient";
    }


    @GetMapping(path="/deletePatient")
    public String deletePatient(Long id)
    {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
  @GetMapping(path = "/formPatient")
    String ajoutPatient(Model model)
    {

        model.addAttribute("patient",new Patient());
        model.addAttribute("mode","new");
        return "formPatient";
    }
    @PostMapping("/savePatient")
   public String  savePatient(@Valid Patient patient,BindingResult bindingResult)
    {
        System.out.println(patient);
        if(bindingResult.hasErrors())
        {System.out.println(bindingResult);
            return "formPatient";}

        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model,Long id)
    {
        try{

            Patient patient= patientRepository.findById(id).get();
            model.addAttribute("patient",patient);
            model.addAttribute("mode","edit");
            return "formPatient";}
        catch(NoSuchElementException e)
        {System.out.println(e.getMessage());}
        return "patient";


    }

    @GetMapping("/login")
    String login()
    {
        return"redirect:/patients";
    }




}
