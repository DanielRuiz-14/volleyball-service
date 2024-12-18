package com.example.demo.player.dto;

import com.example.demo.util.Gender;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String teamName;
  private Integer height;
  private Integer weight;
  private Date birthDate;
  private Integer spike;
  private Integer block;
  private Gender gender;
  private String dni;

}
