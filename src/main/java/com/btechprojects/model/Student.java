package com.btechprojects.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String course;

	private String mobile;

	private Date feeSub;

	private double fee;

	private double paid;

	private double balance;

	private String address;

	private String fatherName;

	private String motherName;

	private Date dateOfBirth;

	private String qualification;
	
	private Date dateOfjoining;
	
	private String description;
	
	private String trainer;

	public Student() {
		super();
	}

	public Student(Long id, String name, String course, String mobile, Date feeSub, double fee, double paid,
			double balance, String address, String fatherName, String motherName, Date dateOfBirth,
			String qualification, Date dateOfjoining, String description, String trainer) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.mobile = mobile;
		this.feeSub = feeSub;
		this.fee = fee;
		this.paid = paid;
		this.balance = balance;
		this.address = address;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.dateOfBirth = dateOfBirth;
		this.qualification = qualification;
		this.dateOfjoining = dateOfjoining;
		this.description = description;
		this.trainer = trainer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getFeeSub() {
		return feeSub;
	}

	public void setFeeSub(Date feeSub) {
		this.feeSub = feeSub;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Date getDateOfjoining() {
		return dateOfjoining;
	}

	public void setDateOfjoining(Date dateOfjoining) {
		this.dateOfjoining = dateOfjoining;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfjoining == null) ? 0 : dateOfjoining.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fatherName == null) ? 0 : fatherName.hashCode());
		temp = Double.doubleToLongBits(fee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((feeSub == null) ? 0 : feeSub.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((motherName == null) ? 0 : motherName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(paid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfjoining == null) {
			if (other.dateOfjoining != null)
				return false;
		} else if (!dateOfjoining.equals(other.dateOfjoining))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fatherName == null) {
			if (other.fatherName != null)
				return false;
		} else if (!fatherName.equals(other.fatherName))
			return false;
		if (Double.doubleToLongBits(fee) != Double.doubleToLongBits(other.fee))
			return false;
		if (feeSub == null) {
			if (other.feeSub != null)
				return false;
		} else if (!feeSub.equals(other.feeSub))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (motherName == null) {
			if (other.motherName != null)
				return false;
		} else if (!motherName.equals(other.motherName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(paid) != Double.doubleToLongBits(other.paid))
			return false;
		if (qualification == null) {
			if (other.qualification != null)
				return false;
		} else if (!qualification.equals(other.qualification))
			return false;
		if (trainer == null) {
            return other.trainer == null;
		} else return trainer.equals(other.trainer);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", course=");
		builder.append(course);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", feeSub=");
		builder.append(feeSub);
		builder.append(", fee=");
		builder.append(fee);
		builder.append(", paid=");
		builder.append(paid);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", address=");
		builder.append(address);
		builder.append(", fatherName=");
		builder.append(fatherName);
		builder.append(", motherName=");
		builder.append(motherName);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append(", dateOfjoining=");
		builder.append(dateOfjoining);
		builder.append(", description=");
		builder.append(description);
		builder.append(", trainer=");
		builder.append(trainer);
		builder.append("]");
		return builder.toString();
	}
	
}
