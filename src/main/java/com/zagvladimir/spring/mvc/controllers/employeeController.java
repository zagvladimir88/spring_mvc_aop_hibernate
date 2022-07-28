package com.zagvladimir.spring.mvc.controllers;

import com.zagvladimir.spring.mvc.dao.EmployeeDAO;
import com.zagvladimir.spring.mvc.dao.EmployeeDaoImpl;
import com.zagvladimir.spring.mvc.entity.Employee;
import com.zagvladimir.spring.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class employeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        model.addAttribute("allEmployees"
                , employeeService.getAllEmployees());

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee );

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);

        return "redirect:/";
    }
}
