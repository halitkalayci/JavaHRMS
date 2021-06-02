package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{
	     @Query("Select r.skills From Resume r Join r.skills  Where r.id=:id")
         List<Skill> findByResume_Id(int id);
}
