package com.example.demo.team.model;

import com.example.demo.util.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "team")
public class Team {

  private Gender gender;

  private String club;

  private String division;

  private String category;

  private String season;

  @Id
  private Long id;

}
