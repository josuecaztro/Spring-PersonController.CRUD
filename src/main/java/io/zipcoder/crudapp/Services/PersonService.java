package io.zipcoder.crudapp.Services;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository repository;

    public PersonService (PersonRepository repo){
        this.repository = repo;
    }

    public Person createPerson (Person p){
        return repository.save(p);
    }

    public Person getPerson (int id){
        return repository.findOne(id);
    }

    public Iterable<Person> getPersonList(){
        return repository.findAll();

    }

    public Person updatePerson (Integer id, Person p){
        Person originalPerson = repository.findOne(id);
        originalPerson.setFirstName(p.getFirstName());
        originalPerson.setLastName(p.getLastName());
        return repository.save(originalPerson);
    }

    public Boolean deletePerson (int id){
        repository.delete(id);
        return true;
    }

}
