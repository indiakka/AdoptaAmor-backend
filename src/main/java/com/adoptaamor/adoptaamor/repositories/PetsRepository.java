package com.adoptaamor.adoptaamor.repositories;

import com.adoptaamor.adoptaamor.models.Pets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Integer> {
    List<Pets> findAllByOrderByIdAsc();
}
