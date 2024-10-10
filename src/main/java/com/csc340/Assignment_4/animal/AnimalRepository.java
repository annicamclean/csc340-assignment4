package com.csc340.Assignment_4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);

    @Query(value = "SELECT * FROM animals a WHERE name LIKE %?%", nativeQuery = true)
    List<Animal> searchAnimalsByName(String name);

}
