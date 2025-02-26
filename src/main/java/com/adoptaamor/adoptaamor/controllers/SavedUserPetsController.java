package com.adoptaamor.adoptaamor.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/userPets")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4001")
public class SavedUserPetsController {

    @PostMapping(value = "userPets")
    public String welcome() {
        return "Welcome form secure endpoint";
    }

}
