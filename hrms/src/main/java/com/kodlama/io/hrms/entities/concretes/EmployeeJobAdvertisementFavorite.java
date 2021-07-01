package com.kodlama.io.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_jobadvertisement_favorites")
public class EmployeeJobAdvertisementFavorite {
     @Id
     @Column(name="favorite_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     @ManyToOne
     @JoinColumn(name="employee_id")
     private Employee employee;

     @ManyToOne
     @JoinColumn(name="jobadvertisement_id")
     private JobAdvertisement jobAdvertisement;
}
