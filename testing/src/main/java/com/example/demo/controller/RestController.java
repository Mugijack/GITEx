package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.entitywork;
import com.example.demo.repo.repository;

import java.util.List;

@Controller
public class RestController {
    @Autowired
    private repository employeeRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        List<entitywork> employees = employeeRepository.findAll();
       
        model.addAttribute("employees", employees);
        return "index";
    }
 

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new entitywork());
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute entitywork employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
    	entitywork employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee id: " + id));
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit/{id}") // Handle form submission for editing employee
    public String editEmployee( @ModelAttribute entitywork employee) {
        employeeRepository.save(employee);
        return "redirect:/"; // Redirect to the home page or employee list after editing
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }
}
