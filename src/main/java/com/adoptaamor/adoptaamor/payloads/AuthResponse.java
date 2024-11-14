package com.adoptaamor.adoptaamor.payloads;

public class AuthResponse {
    private String token;
    private Long userId;
    private String name;
    private String lastName;
    private String dni;
    private String role;

    public AuthResponse(String token, Long userId, String name, String lastName, String dni, String role) {
        this.token = token;
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
