package com.btechprojects.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Accountant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(min=2, max=40)
	private String username;
	
	@NotNull
    @Size(min=2, max=40)
	private String userpass;
	
	@NotNull
	@NotBlank
	private String branch;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJoining;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate dateOfBirth;
	
	@NotNull
	@Range(min = 1, message= "salary may not be empty")
	private double salary;
	

	public Accountant() {
		super();
	}
	
	public Accountant(String username, String userpass, String branch, @NotNull LocalDate dateOfJoining, @NotNull @Past(message = "Only the past is valid") LocalDate dateOfBirth,
			double salary) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.branch = branch;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}

	public Accountant(Long id, String username, String userpass, String branch, @NotNull LocalDate dateOfJoining, @NotNull @Past(message = "Only the past is valid") LocalDate dateOfBirth,
			double salary) {
		super();
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.branch = branch;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(@NotNull LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public @NotNull @Past(message = "Only the past is valid") LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(@NotNull @Past(message = "Only the past is valid") LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpass == null) ? 0 : userpass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accountant other = (Accountant) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpass == null) {
			if (other.userpass != null)
				return false;
		} else if (!userpass.equals(other.userpass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accountant [id=" + id + ", username=" + username + ", userpass=" + userpass + ", branch=" + branch
				+ ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
	}
	
}
