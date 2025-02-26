package com.adoptaamor.adoptaamor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptaamor.adoptaamor.models.SavedUserPets;

public interface  SavedUserPetsRepository extends JpaRepository <SavedUserPets, Integer> {
    
}
