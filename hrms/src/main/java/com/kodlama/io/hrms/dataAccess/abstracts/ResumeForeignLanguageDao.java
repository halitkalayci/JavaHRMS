package com.kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.ResumeForeignLanguage;

public interface ResumeForeignLanguageDao extends JpaRepository<ResumeForeignLanguage, Integer>{

}
