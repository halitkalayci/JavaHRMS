package com.kodlama.io.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	
	@Id
	@Column(name="`UserId`")
	private int userId;

	@Column(name="`CompanyName`")
	private String companyName;
	
	@Column(name="`Phone`")
	private String phone;
	
	@Column(name="`VerifiedBySystem`")
	private boolean verifiedBySystem;
	
	@Column(name="`Website`")
	private String website;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="`UserId`")
	private User user;
	
	public Employer(int userId, String companyName, String phone, boolean verifiedBySystem, String website) {
		this.userId = userId;
		this.companyName = companyName;
		this.phone = phone;
		this.verifiedBySystem = verifiedBySystem;
		this.website = website;
	}
}
