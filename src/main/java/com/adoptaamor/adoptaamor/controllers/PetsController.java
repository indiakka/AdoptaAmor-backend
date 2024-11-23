package com.adoptaamor.adoptaamor.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adoptaamor.adoptaamor.models.Pets;
import com.adoptaamor.adoptaamor.payloads.AnimalDto;
import com.adoptaamor.adoptaamor.services.PetsService;
import com.adoptaamor.adoptaamor.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PetsController {

    private final PetsService petsService;
    private final UserService userService;

    public PetsController(PetsService petsService,UserService userService) {
        this.petsService = petsService;
        this.userService = userService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pets>> getPets() {
        List<Pets> pets = petsService.getPets();
        if (pets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/pets")
    public ResponseEntity<?> crearAnimal(@Valid @RequestBody AnimalDto animalDto) {
        Pets pet = new Pets();
        pet.setNombre(animalDto.getNombre());
        pet.setRaza(animalDto.getRaza());
        pet.setTipo(animalDto.getTipo());
        pet.setTamano(animalDto.getTamano());
        pet.setCuidadosEspeciales(animalDto.getCuidadosEspeciales());
        pet.setEdad(animalDto.getEdad());
        pet.setImagen(animalDto.getImagen());
        pet.setUbicacion(animalDto.getUbicacion() != null ? animalDto.getUbicacion() : "Bilbao");
        pet.setGastosDeGestion("500€"); 
        pet.setUser(userService.getCurrentUser());

        petsService.addPets(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<?> updatePets(@PathVariable("id") int id, @RequestBody AnimalDto animalDto) {
        Optional<Pets> optionalPet = petsService.getPetsById(id);
        if (!optionalPet.isPresent()) {
            return new ResponseEntity<>("Animal no encontrado", HttpStatus.NOT_FOUND);
        }

        Pets pet = optionalPet.get();
        
        pet.setNombre(animalDto.getNombre() != null ? animalDto.getNombre() : pet.getNombre());
        pet.setRaza(animalDto.getRaza() != null ? animalDto.getRaza() : pet.getRaza());
        pet.setTipo(animalDto.getTipo() != null ? animalDto.getTipo() : pet.getTipo());
        pet.setTamano(animalDto.getTamano() != null ? animalDto.getTamano() : pet.getTamano());
        pet.setCuidadosEspeciales(animalDto.getCuidadosEspeciales() != null ? animalDto.getCuidadosEspeciales() : pet.getCuidadosEspeciales());
        pet.setEdad(animalDto.getEdad() > 0 ? animalDto.getEdad() : pet.getEdad());
        pet.setImagen(animalDto.getImagen() != null ? animalDto.getImagen() : pet.getImagen());

        pet.setUbicacion(animalDto.getUbicacion() != null ? animalDto.getUbicacion() : pet.getUbicacion());

        petsService.updatePets(id, pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<?> getPetsById(@PathVariable int id) {
        Optional<Pets> pets = petsService.getPetsById(id);
        if (pets.isPresent()) {
            return ResponseEntity.ok(pets.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal no encontrado");
        }
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        Optional<Pets> existingPets = petsService.findById(id);
        if (existingPets.isPresent()) {
            petsService.delete(existingPets.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
