package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
      List<JobAdvertisement> findByIsActiveTrue();
      List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate();
      List<JobAdvertisement> findByIsActiveTrueAndEmployer_UserId(int userId);
      List<JobAdvertisement> findByIsActiveTrueAndIsApprovedTrue();
      Page<JobAdvertisement> findByIsActiveTrueAndIsApprovedTrue(Pageable pageable);
      JobAdvertisement findByIdAndEmployer_UserId(int id, int userId);
      @Query("Select ja from JobAdvertisement ja JOIN ja.employeeJobAdvertisementFavorites ej JOIN ej.employee e Where e.userId=:userId")
      List<JobAdvertisement> findUserFavoriteJobAds(int userId);
}
