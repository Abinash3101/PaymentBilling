package com.btechprojects.repository;

import com.btechprojects.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {
	
	List<Accountant> findByBranchAndUsernameContainingIgnoreCase(String branch, String username);

	Optional<Accountant> findByBranchAndUsernameAndUserpass(String branch, String username, String password);

}
