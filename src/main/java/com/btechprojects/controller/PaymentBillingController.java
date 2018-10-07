package com.btechprojects.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.btechprojects.model.Accountant;
import com.btechprojects.model.AdminUser;
import com.btechprojects.service.AccountantService;

@Controller
public class PaymentBillingController {
	
	@Autowired
	AccountantService accountService;

    private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/")
	public String welcomePage(Model model) {
        model.addAttribute("accountant", new Accountant());
	    return "index";
	}
	
	@GetMapping("/admin")
	public String adminPage(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message",message);
		model.addAttribute("adminUser", new AdminUser());
		return "admin";
	}
	
	@PostMapping("/ahome")
	public String greetingSubmit(@Valid @ModelAttribute AdminUser admin, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Failed");
            return "admin";
        }
		return "ahome";
	}
	
	@GetMapping("/createAccountant")
	public String createAccountantPage(Model model) {
		model.addAttribute("accountant", new Accountant());
		return "create";
	}
	
	@PostMapping("/asave")
	public String saveAccountant(@Valid @ModelAttribute Accountant accountant, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Failed");
            return "create";
        }
		model.addAttribute("message", accountService.saveAccountant(accountant));
		return "ahome";
	}
	
	@GetMapping("/editAccountant")
	public String editAccountantById(@RequestParam String id, Model model) {
		Optional<Accountant> optionalAccountant = accountService.findAccountantById(id);
		model.addAttribute("accountant", optionalAccountant.get());
		return "create";
	}

	@PostMapping("/loginprocess")
	public String loginProcess(@ModelAttribute Accountant accountant, Model model) {
        Optional<Accountant> optionalAccountant = accountService.findByBranchAndUsernameAndUserpass(accountant);
        if (!optionalAccountant.isPresent()) {
            model.addAttribute("message", "Failed");
            return "index";
        }
        logger.info("Logged in User: {}", optionalAccountant.get());
		return "home";
	}
	
	/*@GetMapping("/ahome")
	public String test() {
		return "/ahome";
	}*/

}
