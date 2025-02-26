package com.adoptaamor.adoptaamor.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.adoptaamor.adoptaamor.repositories.SavedUserPetsRepository;

public class SavedUserPetsService {
    @Autowired
    private SavedUserPetsRepository savedUserPetsRepository;

    public SavedUserPetsService(SavedUserPetsRepository savedUserPetsRepository) {
        this.savedUserPetsRepository = savedUserPetsRepository;
    }

    public SavedUserPetsRepository getSavedUserPetsRepository() {
        return savedUserPetsRepository;
    }

    public void setSavedUserPetsRepository(SavedUserPetsRepository savedUserPetsRepository) {
        this.savedUserPetsRepository = savedUserPetsRepository;
    }

}
