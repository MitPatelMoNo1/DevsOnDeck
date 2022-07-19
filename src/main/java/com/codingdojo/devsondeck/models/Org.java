package com.codingdojo.devsondeck.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    
@Entity
@Table(name="orgs")
public class Org {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Org Name Is Required!")
    @Size(min=3, max=30, message="Org Name must be between 3 and 30 characters")
    private String org;
    
    @NotEmpty(message="Valid Address is required!")
    @Size(min=8, max=128, message="Address must be between 12 and 128 characters")
    private String orgAddress;
    
    @NotEmpty(message="Valid City is required!")
    @Size(min=2, max=128, message="City must be between 2 and 128 characters")
    private String orgCity;
    
    @NotEmpty(message="First Name Is Required!")
    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
    private String firstName;
    
    @NotEmpty(message="Last Name Is Required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lastName;
    
    @NotEmpty(message="Email Is Require!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="State is required!")
    private String state;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password Is Require!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
  
    public Org() {}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
    
