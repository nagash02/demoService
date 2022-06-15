package com.globant.demoService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "person")
public class Person {
  @Id
  private int id;
  private String email;
  private String firstName;
  private String lastName;
  private String avatar;

}
