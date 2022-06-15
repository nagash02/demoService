package com.globant.demoService.service;

import com.globant.demoService.client.ExternalPersonClient;
import com.globant.demoService.model.Message;
import com.globant.demoService.model.ResponseData;
import com.globant.demoService.repository.PersonRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class StorageService {

  @Autowired
  ExternalPersonClient client;

  @Autowired
  private final PersonRepository repository;

  public ResponseEntity<?> getData() {
    try {
      List<ResponseData> data = client.getData();
      if (data.isEmpty()) {
        return new ResponseEntity<>(Message.builder().value("No data to save").build(),
            HttpStatus.OK);
      }
      data.get(0).getData().forEach(repository::save);
      log.info("saved");
      return new ResponseEntity<>(Message.builder().value("saved").build(), HttpStatus.OK);
    } catch (Exception ex) {
      log.error(ex.getMessage());
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }
}
