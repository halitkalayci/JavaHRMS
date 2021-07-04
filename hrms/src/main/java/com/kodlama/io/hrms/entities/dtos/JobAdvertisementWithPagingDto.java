package com.kodlama.io.hrms.entities.dtos;

import java.util.List;

import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithPagingDto {
    private List<JobAdvertisement> jobAdvertisements;
    private int totalPages;
}
