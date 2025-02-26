
package com.adoptaamor.adoptaamor.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userPets")

public class SavedUserPets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long user_idString;

    @Column(nullable = false)
    private Long animal_idString;

    @Column(nullable = false)
    private String animal_typeString;

    @Column(nullable = false, updatable = false)
    private Date savedDate;

    @Column(nullable = true)
    private Date reservedDate;

    @PrePersist
    protected void onCreate() {
        this.savedDate = new Date();
    }
}
