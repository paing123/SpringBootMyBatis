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

import com.paing.model.Admin;
import com.paing.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	// convert empty string to null when form is submit
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = {"/admin" }, method = RequestMethod.GET)
	public String admin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin";
	}

	@RequestMapping(value = { "/addAdmin" }, method = RequestMethod.GET)
	public String showAdminPage(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "addAdmin";
	}

	@RequestMapping(value = { "/addAdmin" }, method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "addAdmin";
		}
		adminService.save(admin);
		Admin adm = new Admin();
		List<Admin> admins = adminService.findAdmin(adm);
		model.addAttribute("admins", admins);
		return "admin";
	}

	@RequestMapping(value = { "/searchAdmin" }, method = RequestMethod.POST)
	public String SearchAdmin(@ModelAttribute("admin") Admin admin, Model model) {
		List<Admin> admins = adminService.findAdmin(admin);
		model.addAttribute("admins", admins);
		return "admin";
	}

	@GetMapping("/deleteAdmin/{id}")
	public ModelAndView deleteAdmin(@ModelAttribute("id") Integer id) {
		adminService.delete(id);	
		Admin adm = new Admin();
		ModelAndView mav = new ModelAndView("admin");
		List<Admin> admins = adminService.findAdmin(adm);
		mav.addObject("admins",admins);
		mav.addObject("admin",adm);
		return mav;
	}
	
	@GetMapping("/updateAdmin/{id}")
	public ModelAndView showUpdateAdmin(@ModelAttribute("id") int id) {
		Admin admin = new Admin();
		admin.setAdminId(id);
		List<Admin> admin1 = adminService.findAdmin(admin);
		admin.setAdminName(admin1.get(0).getAdminName());
		admin.setAge(admin1.get(0).getAge());
		admin.setPhoneNumber(admin1.get(0).getPhoneNumber());
		admin.setAddress(admin1.get(0).getAddress());
		ModelAndView mav = new ModelAndView("updateAdmin");
		mav.addObject("admin", admin);
		return mav;
	}

	@RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
	public ModelAndView UpdateAdmin(@ModelAttribute("admin") Admin admin) {
		adminService.update(admin);
		ModelAndView mav = new ModelAndView("admin");
		Admin adm = new Admin();
		List<Admin> admins = adminService.findAdmin(adm);
		mav.addObject("admins", admins);
		return mav;
	}
}