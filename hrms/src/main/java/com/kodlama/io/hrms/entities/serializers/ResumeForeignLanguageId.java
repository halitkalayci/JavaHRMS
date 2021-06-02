package com.kodlama.io.hrms.entities.serializers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.kodlama.io.hrms.entities.concretes.ForeignLanguage;
import com.kodlama.io.hrms.entities.concretes.Resume;

import lombok.Data;

@Embeddable
@Data

public class ResumeForeignLanguageId implements Serializable{
	private Resume resume;
	private ForeignLanguage foreignLanguage;
	
	public int hashCode() {
		return resume.getId()+foreignLanguage.getId();
	}
	
	public boolean equals(Object object) {
	    if (object instanceof ResumeForeignLanguageId) {
	    	ResumeForeignLanguageId otherId = (ResumeForeignLanguageId) object;
	      return (otherId.resume.getId() == this.resume.getId()) 
	              && (otherId.foreignLanguage.getId() == this.foreignLanguage.getId());
	    }
	    return false;
	  }

}
