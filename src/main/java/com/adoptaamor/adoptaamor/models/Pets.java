package com.adoptaamor.adoptaamor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pets") 
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El tipo es obligatorio")
    @NotNull(message = "El tipo de animal no puede estar vacío")
    @Size(min = 3, max = 50, message = "El tipo debe tener entre 3 y 50 caracteres")
    private String tipo;

    @NotBlank(message = "El nombre es obligatorio")
    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La raza es obligatoria")
    @NotNull(message = "La raza no puede estar vacía")
    @Size(min = 1, max = 50, message = "La raza debe tener entre 1 y 50 caracteres")
    private String raza;

    @NotBlank(message = "El tamaño es obligatorio")
    @NotNull(message = "El tamaño no puede estar vacío")
    private String tamano;

    @Size(max = 255, message = "Los cuidados especiales no pueden exceder los 255 caracteres")
    private String cuidadosEspeciales;

    @NotBlank(message = "La ubicación es obligatoria")
    @NotNull(message = "La ubicación no puede estar vacía")
    @Size(min = 3, max = 100, message = "La ubicación debe tener entre 3 y 100 caracteres")
    private String ubicacion;

    @Min(value = -1, message = "La edad no puede ser negativa")
    @Max(value = 30, message = "La edad no puede ser mayor a 30 años")
    private int edad;

    @NotNull(message = "Los gastos de gestión no pueden estar vacíos")
    @Size(max = 50, message = "Los gastos de gestión no pueden exceder los 50 caracteres")
    private String gastosDeGestion;

    @Size(max = 255, message = "La URL de la imagen no puede exceder los 255 caracteres")
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "id_user",  nullable = false)
    private User user;

    public Pets() {
    }

    public Pets(int id, String tipo, String nombre, String raza, String tamano, String cuidadosEspeciales,
            String ubicacion, int edad, String gastosDeGestion, String imagen) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.raza = raza;
        this.tamano = tamano;
        this.cuidadosEspeciales = cuidadosEspeciales;
        this.ubicacion = ubicacion;
        this.edad = edad;
        this.gastosDeGestion = gastosDeGestion;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGastosDeGestion() {
        return gastosDeGestion;
    }

    public void setGastosDeGestion(String gastosDeGestion) {
        this.gastosDeGestion = gastosDeGestion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", tamano='" + tamano + '\'' +
                ", cuidadosEspeciales='" + cuidadosEspeciales + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", edad=" + edad +
                ", gastosDeGestion='" + gastosDeGestion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
