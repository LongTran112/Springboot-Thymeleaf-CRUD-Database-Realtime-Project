package com.company.controller;

import com.company.entity.Employee;
import com.company.service.EmployeeService;
import com.company.util.Mappings;
import com.company.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(Mappings.EMPLOYEES)
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(Mappings.LIST)
    public String listEmployees(Model model){
        //DATA BINDING
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);

        //REFER TO FILES IN TEMPLATES FOLDER
        return ViewNames.LIST_EMPLOYEES;
    }

    @GetMapping(Mappings.ADD)
    public String addEmployee(Model model){
        //DATA BINDING
        Employee employee = new Employee();
        model.addAttribute("employee",employee);

        //REFER TO FILES IN TEMPLATES FOLDER
        return ViewNames.ADD_EMPLOYEES;
    }

    @PostMapping(Mappings.SAVE)
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
//        USE REDIRECT TO PREVENT DUPLICATION SUBMISSIONS FROM REFRESHING PAGE
        return ViewNames.REDIRECT_LIST_EMPLOYEES;
    }

    @GetMapping(Mappings.UPDATE)
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);

        return ViewNames.ADD_EMPLOYEES;
    }

    @GetMapping(Mappings.DELETE)
    public String deleteEmployee(@RequestParam("employeeId") int id, Model model){
        employeeService.deleteById(id);
        return ViewNames.REDIRECT_LIST_EMPLOYEES;
    }



}
