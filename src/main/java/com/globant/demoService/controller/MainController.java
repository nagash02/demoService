package com.globant.demoService.controller;

import com.globant.demoService.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Api(tags = "Demo", value = "I am a demo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Log4j2
public class MainController {

  @Autowired
  private StorageService service;

  @ApiOperation(value = "test", notes = "")
  @ApiResponses({@ApiResponse(code = 200, message = "correct", response = HttpStatus.class)})
  @GetMapping(value = "/demo")
  public ResponseEntity<?> testService(){
    return service.getData();
  }

}
