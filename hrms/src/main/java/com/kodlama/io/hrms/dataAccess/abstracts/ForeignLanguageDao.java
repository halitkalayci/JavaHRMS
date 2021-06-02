package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrms.entities.concretes.ForeignLanguage;
import com.kodlama.io.hrms.entities.dtos.ForeignLanguageDetailsDto;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{
   @Query("Select new com.kodlama.io.hrms.entities.dtos.ForeignLanguageDetailsDto(fl.name, rfl.ratio) "
   		+ "From ForeignLanguage fl JOIN fl.resumeForeignLanguages rfl Where rfl.resume.id = :id")
   List<ForeignLanguageDetailsDto> findByResume_ResumeId(int id);
}
