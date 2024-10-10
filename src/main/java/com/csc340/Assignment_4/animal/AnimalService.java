package com.csc340.Assignment_4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {return animalRepository.findAll();}

    public void addNewAnimal(Animal animal) {animalRepository.save(animal);}

    public Animal getAnimalById(int animalId) {return animalRepository.findById(animalId).orElse(null);}

    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    public void deleteAnimalById(int animalId) {animalRepository.deleteById(animalId);}

    public List<Animal> getAnimalsBySpecies(String species) {return animalRepository.getAnimalsBySpecies(species);}

    public List<Animal> searchAnimalsByName(String name) {return animalRepository.searchAnimalsByName(name);}
}
