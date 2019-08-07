package com.example.jpajava.repository;

import com.example.jpajava.entity.Person;

import org.springframework.data.repository.CrudRepository;

/**
 * PersonRepository
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}