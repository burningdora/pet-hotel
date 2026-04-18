package com.pethotel.pet_hotel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        return animalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Long id, @RequestBody Animal updated) {
        return animalRepository.findById(id).map(animal -> {
            animal.setName(updated.getName());
            animal.setType(updated.getType());
            animal.setOwnerName(updated.getOwnerName());
            animal.setOwnerPhone(updated.getOwnerPhone());
            return animalRepository.save(animal);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        animalRepository.deleteById(id);
    }
}
