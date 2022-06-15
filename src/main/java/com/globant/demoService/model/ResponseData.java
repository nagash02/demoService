package com.globant.demoService.model;

import com.globant.demoService.model.Person;
import java.util.List;
import lombok.Data;

@Data
public class ResponseData {
  private int page;
  private int perPage;
  private int total;
  private int totalPage;
  private List<Person> data;

}
