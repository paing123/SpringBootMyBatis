package com.paing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paing.model.Employee;
import com.paing.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// convert empty string to null when form is submit
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = { "/employee" }, method = RequestMethod.GET)
	public String employee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee";
	}

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	public String showEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "addEmployee";
		}
		employeeService.save(employee);
		Employee emp = new Employee();
		List<Employee> employees = employeeService.findEmployee(emp);
		model.addAttribute("employees", employees);
		return "employee";
	}

	@RequestMapping(value = { "/searchEmployee" }, method = RequestMethod.POST)
	public String SearchEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		List<Employee> employees = employeeService.findEmployee(employee);
		model.addAttribute("employees", employees);
		return "employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public ModelAndView deleteEmployee(@ModelAttribute("id") Integer id) {
		employeeService.delete(id);	
		Employee employee = new Employee();
		ModelAndView mav = new ModelAndView("employee");
		List<Employee> employees = employeeService.findEmployee(employee);
		mav.addObject("employees",employees);
		mav.addObject("employee",employee);
		return mav;
	}
	
	@GetMapping("/updateEmployee/{id}")
	public ModelAndView showUpdateUserForm(@ModelAttribute("id") int id) {
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		List<Employee> employee1 = employeeService.findEmployee(employee);
		employee.setEmployeeName(employee1.get(0).getEmployeeName());
		employee.setAge(employee1.get(0).getAge());
		employee.setSalary(employee1.get(0).getSalary());
		employee.setPosition(employee1.get(0).getPosition());
		employee.setGender(employee1.get(0).getGender());
		employee.setPhoneNumber(employee1.get(0).getPhoneNumber());
		employee.setAddress(employee1.get(0).getAddress());
		employee.setUpdatedDate(employee1.get(0).getUpdatedDate());
		ModelAndView mav = new ModelAndView("updateEmployee");
		mav.addObject("employee", employee);
		return mav;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView UpdateEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.update(employee);
		ModelAndView mav = new ModelAndView("employee");
		Employee emp = new Employee();
		List<Employee> employees = employeeService.findEmployee(emp);
		mav.addObject("employees", employees);
		return mav;
	}
}