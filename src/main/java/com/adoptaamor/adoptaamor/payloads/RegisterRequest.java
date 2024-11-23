package com.adoptaamor.adoptaamor.payloads;

import com.adoptaamor.adoptaamor.models.role.Role; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String lastname;
    private String dni;
    private String password;
    private String email;
    private Role role; 
}
