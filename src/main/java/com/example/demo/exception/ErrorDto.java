package com.example.demo.exception;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {

  private int status;
  private String message;
  private long timestamp;

}
