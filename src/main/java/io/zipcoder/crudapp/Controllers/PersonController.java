package io.zipcoder.crudapp.Controllers;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> createPerson (@RequestBody Person p){
        return new ResponseEntity<>(service.createPerson(p), HttpStatus.CREATED);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Person> getPerson (@PathVariable("id") int id){
        return new ResponseEntity<>(service.getPerson(id), HttpStatus.OK);
    }

    @GetMapping(value = "/persons")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(service.getPersonList(), HttpStatus.OK);

    }

    @PutMapping(value = "/persons/{id}")
    public ResponseEntity<Person> updatePerson (@PathVariable("id")Integer id, Person p){
        return new ResponseEntity<>(service.updatePerson(id, p), HttpStatus.OK);

    }

    public ResponseEntity<Boolean> deletePerson (@PathVariable("id") int id){
        return new ResponseEntity<>(service.deletePerson(id), HttpStatus.OK);
    }

}
