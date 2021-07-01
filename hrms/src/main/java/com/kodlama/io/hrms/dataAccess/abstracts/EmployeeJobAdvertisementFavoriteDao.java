package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.EmployeeJobAdvertisementFavorite;

public interface EmployeeJobAdvertisementFavoriteDao extends JpaRepository<EmployeeJobAdvertisementFavorite, Integer> {
        List<EmployeeJobAdvertisementFavorite> getByEmployee_UserId(int id);
        EmployeeJobAdvertisementFavorite getByEmployee_UserIdAndJobAdvertisementId(int employeeId,int jobAdId);
}
