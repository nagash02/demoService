package com.globant.demoService.repository;

import com.globant.demoService.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Integer> {

}
