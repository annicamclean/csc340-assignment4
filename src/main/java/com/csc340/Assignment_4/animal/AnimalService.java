package com.csc340.Assignment_4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Animal Database.
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {return animalRepository.findAll();}

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) {animalRepository.save(animal);}

    /**
     * Fetch a unique animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {return animalRepository.findById(animalId).orElse(null);}

    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new Animal details.
     */
    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Animal Id.
     */
    public void deleteAnimalById(int animalId) {animalRepository.deleteById(animalId);}

    /**
     * Fetch all animals whose major matches the search term.
     *
     * @param species the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsBySpecies(String species) {return animalRepository.getAnimalsBySpecies(species);}

    /**
     * Fetch all animals with a name similar to the searched name.
     *
     * @param name search name
     * @return the list of matching Animals
     */
    public List<Animal> searchAnimalsByName(String name) {return animalRepository.searchAnimalsByName(name);}
}
