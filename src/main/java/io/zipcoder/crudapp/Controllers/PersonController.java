package io.zipcoder.crudapp.Controllers;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonService service;

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> createPerson (@RequestBody Person p){
        return new ResponseEntity<>(service.create(Person), HttpStatus.OK);
    }

    public Person getPerson (int id){
        return null;
    }

    public List<Person> getPersonList(){
        return null;

    }

    public Person updatePerson (Person p){
        return null;

    }

    public void deletePerson (int id){

    }

}
