package com.example.jpajava.repository;

import com.example.jpajava.entity.Animal;

import org.springframework.data.repository.CrudRepository;

/**
 * AnimalRepository
 */
public interface AnimalRepository extends CrudRepository<Animal, Long> {
}