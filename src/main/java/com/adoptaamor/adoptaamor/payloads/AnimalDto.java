package com.adoptaamor.adoptaamor.payloads;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AnimalDto {

    @NotBlank(message = "El tipo es obligatorio")
    @NotNull(message = "El tipo no puede estar vacío")
    private String tipo;

    @NotBlank(message ="El nombre es obligatorio")
    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 50)
    private String nombre;

    @NotBlank(message = "La raza es obligatoria")
    @NotNull(message = "La raza no puede estar vacía")
    private String raza;

    @NotBlank(message = "El tamaño es obligatorio")
    @NotNull(message = "El tamaño no puede estar vacío")
    private String tamano;    


    private String cuidadosEspeciales; 

    @Min(value = -1, message = "La edad no puede ser negativa")
    @Max(value = 30, message = "La edad no puede ser mayor a 30 años")
    @NotNull(message = "La edad no puede estar vacía")
    private int edad;

    private String imagen;
    
    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion; 

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getCuidadosEspeciales() {
        return cuidadosEspeciales;
    }

    public void setCuidadosEspeciales(String cuidadosEspeciales) {
        this.cuidadosEspeciales = cuidadosEspeciales;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
