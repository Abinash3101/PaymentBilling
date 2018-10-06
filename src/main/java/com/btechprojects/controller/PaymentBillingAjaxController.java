package com.btechprojects.controller;

import com.btechprojects.model.Accountant;
import com.btechprojects.service.AccountantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PaymentBillingAjaxController {
	
	@Autowired
	private AccountantService accountService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/afindname")
	public ResponseEntity<List<Accountant>> findAccountantByName(@RequestParam(value = "val", defaultValue = "") String val,
			@RequestParam(value = "branch", defaultValue = "") String branch, Model model) {
		List<Accountant> retrivedAccountants = accountService.findAccountantByBranchAndName(branch, val);
		System.out.println(retrivedAccountants);
		return new ResponseEntity<>(retrivedAccountants, HttpStatus.OK);
	}
	
	@GetMapping("/aviewall")
	public ResponseEntity<Accountant> findAccountantById(@RequestParam(value = "val", defaultValue = "") String val) {
		logger.info("Id value----->"+val);
		Optional<Accountant> optionalAccountant = accountService.findAccountantById(val);
		logger.info("Retrived Accountant is {}", optionalAccountant.get());
		return new ResponseEntity<>(optionalAccountant.get(), HttpStatus.OK);
	}
	
	@GetMapping("/adelete")
	public ResponseEntity<String> deleteAccountantById(@RequestParam(value = "val", defaultValue = "") String val) {
		logger.info("Id value need to delete----->"+val);
		String status = accountService.deleteAccountantById(val);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
