package com.codingdojo.devsondeck.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="devs")
public class Devs {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String devname;
    @NotNull
    @Size(min = 5, max = 200)
    private String devdescription;
    
    @NotNull
	@NotNull(message="Languages Are Required")
    private String languages;
    
    @NotNull
	@NotNull(message="Frameworks Are Required")
    private String frameworks;
    public Devs() {
    }
 
	
	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	public String getFrameworks() {
		return frameworks;
	}


	public void setFrameworks(String frameworks) {
		this.frameworks = frameworks;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDevname() {
		return devname;
	}


	public void setDevname(String devname) {
		this.devname = devname;
	}


	public String getDevdescription() {
		return devdescription;
	}


	public void setDevdescription(String devdescription) {
		this.devdescription = devdescription;
	}


	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
	

