package com.csc340.Assignment_4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public List<Animal> getAllAnimals() {return service.getAllAnimals();}

    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {return service.getAnimalById(animalId);}

    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }

    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "species1")String species) {
        return service.getAnimalsBySpecies(species);
    }

    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam(name = "name", defaultValue = "name1")String name) {
        return service.searchAnimalsByName(name);
    }
}
