package com.btechprojects.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btechprojects.model.Accountant;
import com.btechprojects.repository.AccountantRepository;

@Service
public class AccountantService {
	
	@Autowired
	AccountantRepository accountantRepo;
	
	public String saveAccountant(final Accountant accountant) {
		accountantRepo.save(accountant);
		return "Success";
	}

	public List<Accountant> findAccountantByBranchAndName(String branch, String username) {
		return accountantRepo.findByBranchAndUsernameContainingIgnoreCase(branch, username);
	}
	
	public Optional<Accountant> findAccountantById(String id) {
		Optional<Accountant> optionalAccountant = accountantRepo.findById(Long.parseLong(id));
		if (optionalAccountant.isPresent()) {
			return optionalAccountant;
		}
		return Optional.empty();
	}
	
	public String deleteAccountantById(String id) {
		try {
			accountantRepo.deleteById(Long.parseLong(id));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return "Could not able to delete...";
		}
		return "Accountant deleted Successfully...";
	}

}
