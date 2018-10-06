package com.btechprojects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btechprojects.model.Accountant;
import java.lang.String;
import java.util.List;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {
	
	List<Accountant> findByBranchAndUsernameContainingIgnoreCase(String branch, String username);

}
