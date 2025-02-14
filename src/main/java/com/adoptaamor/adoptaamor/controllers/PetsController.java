package com.adoptaamor.adoptaamor.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adoptaamor.adoptaamor.models.Pets;
import com.adoptaamor.adoptaamor.payloads.AnimalDto;
import com.adoptaamor.adoptaamor.services.FileStorageService;
import com.adoptaamor.adoptaamor.services.PetsService;
import com.adoptaamor.adoptaamor.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PetsController {

    private final PetsService petsService;
    private final UserService userService;
    private final FileStorageService fileStorageService; 

    public PetsController(PetsService petsService, UserService userService, FileStorageService fileStorageService) {
        this.petsService = petsService;
        this.userService = userService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pets>> getPets() {
        List<Pets> pets = petsService.getPets();
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
    public ResponseEntity<?> updatePets(
            @PathVariable("id") int id,
            @RequestParam("tipo") String tipo,
            @RequestParam("nombre") String nombre,
            @RequestParam("raza") String raza,
            @RequestParam("tamano") String tamano,
            @RequestParam("cuidadosEspeciales") String cuidadosEspeciales,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("edad") int edad,
            @RequestParam(value = "imagen", required = false) MultipartFile imagen) {

        Optional<Pets> optionalPet = petsService.getPetsById(id);
        if (!optionalPet.isPresent()) {
            return new ResponseEntity<>("Animal no encontrado", HttpStatus.NOT_FOUND);
        }

        Pets pet = optionalPet.get();

        pet.setNombre(nombre != null ? nombre : pet.getNombre());
        pet.setRaza(raza != null ? raza : pet.getRaza());
        pet.setTipo(tipo != null ? tipo : pet.getTipo());
        pet.setTamano(tamano != null ? tamano : pet.getTamano());
        pet.setCuidadosEspeciales(cuidadosEspeciales != null ? cuidadosEspeciales : pet.getCuidadosEspeciales());
        pet.setEdad(edad > 0 ? edad : pet.getEdad());
        pet.setUbicacion(ubicacion != null ? ubicacion : pet.getUbicacion());

        if (imagen != null && !imagen.isEmpty()) {
            String imageUrl = fileStorageService.storeFile(imagen);
            if (imageUrl != null) {
                pet.setImagen(imageUrl); 
            }
        }

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
