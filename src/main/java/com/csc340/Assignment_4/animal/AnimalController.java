package com.csc340.Assignment_4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {return service.getAllAnimals();}

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for a Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {return service.getAnimalById(animalId);}

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{"animalId": 2, "name": "name2", "scientificName": "scientificName2", "species": "species2", "habitat": "habitat2", "description": "description2"}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{"animalId": 4, "name": "updatedName", "scientificName": "scientificName4", "species": "species4", "habitat": "habitat4", "description": "description4"}'
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }

    /**
     * Get a list of Animals based on their species.
     * http://localhost:8080/animals/species?species=species1
     *
     * @param species the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "species1")String species) {
        return service.getAnimalsBySpecies(species);
    }

    /**
     * Get a list of Animals with a name similar to the search name.
     * http://localhost:8080/animals/search?name=name1
     *
     * @param name the name being searched
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam(name = "name", defaultValue = "name1")String name) {
        return service.searchAnimalsByName(name);
    }
}
