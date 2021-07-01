package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrms.entities.concretes.JobPosition;
import com.kodlama.io.hrms.entities.dtos.JobPositionForListingDto;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	@Query("Select new com.kodlama.io.hrms.entities.dtos.JobPositionForListingDto(jp.id,jp.positionName,COUNT(ja.id)) "
			+ "FROM JobPosition jp JOIN jp.jobAdvertisements ja where ja.isActive=true group by jp.id,jp.positionName ")
	List<JobPositionForListingDto> getAllWithJobAdCount();
	JobPosition findByPositionName(String positionName);
	JobPosition findById(int id);
}
