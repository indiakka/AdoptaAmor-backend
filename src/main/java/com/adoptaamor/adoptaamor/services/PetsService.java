package com.adoptaamor.adoptaamor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adoptaamor.adoptaamor.models.Pets;
import com.adoptaamor.adoptaamor.repositories.PetsRepository;

@Service
public class PetsService {

    private final PetsRepository petsRepository;

    public PetsService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public List<Pets> getPets() {
        return petsRepository.findAllByOrderByIdAsc();
    }

    public ResponseEntity<Object> addPets(Pets pets) {
        petsRepository.save(pets);
        return new ResponseEntity<>(pets, HttpStatus.CREATED);
    }

    public void delete(Pets pets) {
        this.petsRepository.delete(pets);
    }

    public ResponseEntity<Object> updatePets(int id, Pets pets) {
        Optional<Pets> existingPets = petsRepository.findById(id);
        if (existingPets.isPresent()) {
            Pets updatePets = existingPets.get();

            updatePets.setNombre(pets.getNombre());
            updatePets.setUbicacion(pets.getUbicacion());
            updatePets.setImagen(pets.getImagen());
            updatePets.setTipo(pets.getTipo());
            updatePets.setRaza(pets.getRaza());
            updatePets.setTamano(pets.getTamano());
            updatePets.setCuidadosEspeciales(pets.getCuidadosEspeciales());
            updatePets.setEdad(pets.getEdad());
            updatePets.setGastosDeGestion(pets.getGastosDeGestion());

            petsRepository.save(updatePets);
            return new ResponseEntity<>(updatePets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Animal no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public Optional<Pets> findById(int id) { 
        return petsRepository.findById(id);
    }

    public Optional<Pets> getPetsById(int id) {
        return petsRepository.findById(id);
    }
}
