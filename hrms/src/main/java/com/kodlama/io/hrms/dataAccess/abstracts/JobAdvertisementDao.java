package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
      List<JobAdvertisement> findByIsActiveTrue();
      List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate();
      List<JobAdvertisement> findByIsActiveTrueAndEmployer_UserId(int userId);
      JobAdvertisement findByIdAndEmployer_UserId(int id, int userId);
}
