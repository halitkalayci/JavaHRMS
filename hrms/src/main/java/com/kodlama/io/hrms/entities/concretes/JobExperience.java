package com.kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="job_experience")
public class JobExperience {
      @Id()
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id")
      private int id;
      
      @Column(name = "office_name",nullable=false)
      private String officeName;
      
      @Column(name = "position",nullable=false)
      private String position;
      
      @Column(name = "start_date",nullable=false)
      private Date startDate;
      
      @Column(name = "end_date",nullable=true)
      private Date endDate;
      
      @ManyToOne()
      @JoinColumn(name="resume_id")
      @JsonIgnore
      private Resume resume;
}
