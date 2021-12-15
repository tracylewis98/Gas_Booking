package com.gasbooking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;

	@Pattern(regexp = "[a-zA-Z0-9]{3,}", message = "UserName should have atleast 3 characters")
	String username;

	// password should not be null or empty
	// password should have minimum 4 characters
	@Pattern(regexp = "[a-zA-Z0-9@/!<>$#-_]{4,}", message = "password should have atleast 4 characters")
	String password;

	// address should not be null or empty
	// address should have minimum 8 characters
	@Pattern(regexp = "[a-zA-Z0-9-_/]{8,}", message = "Should Provide proper address")
	String address;

	// mobileNumber should not be null or empty
	// mobileNumber should have 10 characters
	@Pattern(regexp = "^[7-9][0-9]{9}", message = "mobile number should have only 10 characters")
	String mobileNumber;

	// mobileNumber should not be null or empty
	// mobileNumber should have minimun 8 characters

	@Pattern(regexp = "[a-zA-Z]{3,}@[a-zA-Z]{2,}.[a-zA-Z]{2,}", message = "Please Provide the valid format of email")
	String email;

	public AbstractUser() {
		super();
	}

	public AbstractUser(
			@Pattern(regexp = "[a-zA-Z0-9]*", message = "Username should have atleast 8 characters") String username,
			@Pattern(regexp = "[a-zA-Z0-9@/!<>$#-_]*", message = "password should have atleast 4 characters") String password,
			@Pattern(regexp = "[a-zA-Z0-9-_]*", message = "Should Provide proper address") String address,
			@Pattern(regexp = "^[7-9][0-9]{9}", message = "mobile number should have atleast 10 characters") String mobileNumber,
			@Pattern(regexp = "[a-zA-Z]{3,}@[a-zA-Z]{2,}.[a-zA-Z]{2,}", message = "email should have atleaz") String email) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}