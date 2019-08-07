package com.example.jpajava.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.example.jpajava.entity.Animal;
import com.example.jpajava.entity.Person;
import com.example.jpajava.repository.AnimalRepository;
import com.example.jpajava.repository.PersonRepository;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JPAServiceTests
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAServiceTest {

    static JPAService jpaService;
    
    @Autowired
    PersonRepository personRepository;

    @Autowired
    AnimalRepository animalRepository;

    @BeforeClass
    public static void setUp() {
        jpaService = new JPAService();
    }

    private Person getPersonData() {
        Person person = new Person();
        person.setId(1L);
        person.setAge(22);
        person.setName("jack");
        return person;
    }

    private Animal getAnimalData() {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setTitle("cat");
        return animal;
    }

    private Animal getAniamlData(Person person) {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setTitle("cat");
        animal.setPerson(person);
    
        person.setAnimal(Arrays.asList(animal));
        
        return animal;
    }

    private Person getPersonAnimalData(Person person) {
        Animal animal1 = new Animal();
        animal1.setId(1L);
        animal1.setTitle("cat");
        animal1.setPerson(person);
        
        Animal animal2 = new Animal();
        animal2.setId(2L);
        animal2.setTitle("dog");
        animal2.setPerson(person);
        
        Animal animal3 = new Animal();
        animal3.setId(3L);
        animal3.setTitle("netty");
        animal3.setPerson(person);

        person.setAnimal(Arrays.asList(animal1, animal2, animal3));

        return person;
    }

    @Test
    public void setPersonTest() {
        Person person = getPersonData();
        personRepository.save(person);
    }


    @Test
    public void setAnimalTest() {
        Person person = personRepository.findById(1L).get();
        Animal animal = getAnimalData();
        person.setAnimal(Arrays.asList(animal));
        personRepository.save(person);
    }

    @Test
    public void setPersonAnimalTest() {
        Person person = personRepository.findById(1L).get();
        Animal aniamlData = getAniamlData(person);
        animalRepository.save(aniamlData);
    }

    @Test
    public void setAnimalPersonTest() {
        Person person = personRepository.findById(1L).get();
        getPersonAnimalData(person);
        personRepository.save(person);
    }

    @Test
    @Transactional
    public void getPersonTest() {
        Person person = personRepository.findById(1L).get();
        // 두 객체의 주소값 비교
        assertSame(person.getId(), 1L);
        assertSame(person.getAge(), 22);
        // 두 객체이 값 비교
        assertEquals(person.getName(), "jack");
        List<Animal> animals = person.getAnimal();
        Animal animal = animals.get(0);
        assertEquals(animal.getId(), 1L);
        assertEquals(animal.getTitle(), "cat");
        
        animal = animals.get(1);
        assertEquals(animal.getId(), 2L);
        assertEquals(animal.getTitle(), "dog");
        
        animal = animals.get(2);
        assertEquals(animal.getId(), 3L);
        assertEquals(animal.getTitle(), "netty");
        


    }
}