package com.kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employer_update_requests")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="updaterequest_id",nullable=false)
    private int id;
	
	@Column(name="updated_company_name")
	private String updatedCompanyName;
	
	@Column(name="updated_company_phone")
	private String updatedCompanyPhone;
	
	@Column(name="updated_company_website")
	private String updatedCompanyWebsite;
	
	@Column(name="updated_company_email")
	private String updatedCompanyEmail;
	
	@Column(name="updated_avatar_path")
	private String updatedAvatarPath;
	
	@Column(name="update_date")
	private LocalDate updateDate;
	
	@Column(name="approved_date")
	private LocalDate approvedDate;
	
	@Column(name="is_approved",nullable = true)
	private Boolean isApproved;
	
	@Column(name="approve_description",nullable = true)
	private String approveDescription;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="systemuser_id")
	private SystemUser systemUser;

	public EmployerUpdateRequest(Employer employer,String updatedCompanyName, String updatedCompanyPhone, String updatedCompanyWebsite,
			String updatedCompanyEmail, LocalDate updateDate) {
		super();
		this.employer = employer;
		this.updatedCompanyName = updatedCompanyName;
		this.updatedCompanyPhone = updatedCompanyPhone;
		this.updatedCompanyWebsite = updatedCompanyWebsite;
		this.updatedCompanyEmail = updatedCompanyEmail;
		this.updateDate = updateDate;
	}

	
	
	
	
}
