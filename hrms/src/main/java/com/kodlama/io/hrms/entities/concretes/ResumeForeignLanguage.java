package com.kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.kodlama.io.hrms.entities.serializers.ResumeForeignLanguageId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_foreign_languages")
@IdClass(ResumeForeignLanguageId.class)
public class ResumeForeignLanguage {

	@Id
    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;

    @Id
    @ManyToOne
    @JoinColumn(name="foreign_language_id")
    private ForeignLanguage foreignLanguage;
    
    
	@Column(name = "ratio")
	private int ratio;

}
