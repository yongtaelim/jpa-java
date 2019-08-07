package com.example.jpajava.service;

import com.example.jpajava.entity.Animal;
import com.example.jpajava.entity.Person;
import com.example.jpajava.repository.AnimalRepository;
import com.example.jpajava.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * JPAService
 */
public class JPAService {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    PersonRepository personRepository;

    public Iterable<Animal> getAllAnimal() {        
        return animalRepository.findAll();
    }

    public void setAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public Animal getAnimal(long id) {
        return animalRepository.findById(id).get();
    }

    public Iterable<Person> getAllPerson() {        
        return personRepository.findAll();
    }

    public void setPerson(Person person) {
        personRepository.save(person);
    }

    public Person getPerson(long id) {
        return personRepository.findById(id).get();
    }
}