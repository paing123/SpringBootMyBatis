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

import com.paing.model.Customer;
import com.paing.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// convert empty string to null when form is submit
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = { "/", "/customer" }, method = RequestMethod.GET)
	public String customer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
	public String showCustomerPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "addCustomer";
		}
		customerService.save(customer);
		Customer cus = new Customer();
		List<Customer> customers = customerService.findCustomer(cus);
		model.addAttribute("customers", customers);
		return "customer";
	}

	@RequestMapping(value = { "/searchCustomer" }, method = RequestMethod.POST)
	public String SearchCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		List<Customer> customers = customerService.findCustomer(customer);
		model.addAttribute("customers", customers);
		return "customer";
	}

	@GetMapping("/deleteCustomer/{id}")
	public ModelAndView deleteCustomer(@ModelAttribute("id") Integer id) {
		customerService.delete(id);	
		Customer cus = new Customer();
		ModelAndView mav = new ModelAndView("customer");
		List<Customer> customers = customerService.findCustomer(cus);
		mav.addObject("customers",customers);
		mav.addObject("customer",cus);
		return mav;
	}
	
	@GetMapping("/updateCustomer/{id}")
	public ModelAndView showUpdateUserForm(@ModelAttribute("id") int id) {
		Customer customer = new Customer();
		customer.setCustomerId(id);
		List<Customer> customer1 = customerService.findCustomer(customer);
		customer.setAddress(customer1.get(0).getAddress());
		customer.setAge(customer1.get(0).getAge());
		customer.setCustomerName(customer1.get(0).getCustomerName());
		customer.setGender(customer1.get(0).getGender());
		customer.setPhoneNumber(customer1.get(0).getPhoneNumber());
		customer.setUpdatedDate(customer1.get(0).getUpdatedDate());
		ModelAndView mav = new ModelAndView("updateCustomer");
		mav.addObject("customer", customer);
		return mav;
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public ModelAndView UpdateCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.update(customer);
		ModelAndView mav = new ModelAndView("customer");
		Customer cus = new Customer();
		List<Customer> customers = customerService.findCustomer(cus);
		mav.addObject("customers", customers);
		return mav;
	}
}