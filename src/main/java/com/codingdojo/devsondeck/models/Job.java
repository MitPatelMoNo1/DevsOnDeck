package com.codingdojo.devsondeck.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Name is Required")
	@Size(min = 3, max = 100, message="This Field Is Required.")
	private String jobname;
	
	@NotNull(message="Description Is Required")
	@Size(min = 3, max = 100, message="This Field Is Required.")
	private String jobdesc;
	
	@NotNull
	@NotNull(message="Skills Are Required")
    private String skills;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    public Job() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public String getJobname() {
		return jobname;
	}



	public void setJobname(String jobname) {
		this.jobname = jobname;
	}



	public String getJobdesc() {
		return jobdesc;
	}



	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	public String getJobDesc() {
		return jobdesc;
	}

	public void setJobDesc(String desc) {
		this.jobdesc = desc;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public void setOrg(Org org) {
		// TODO Auto-generated method stub
		
	}
    
}
