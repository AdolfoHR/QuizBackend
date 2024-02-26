package com.derechos.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long usuarioId;

    @Column(name = "nombre_usuario")
    @Size(min = 3, max = 15)
    private String nombreUsuario;

    @Column(name = "apellido_usuario")
    @Size(min = 3, max = 15)
    private String apellidoUsuario;

    @Column(name = "edad_usuario")
    @Min(value = 1, message = "Tienes que indicar un número mayor a 1")
    @Max(value = 10, message = "Tienes que indicar un número menor a 10")
    private Integer aniosUsuario;

    @Email(message = "No se introdujo un correo valido")
    private String correoUsuario;


    @NotNull(message = "El género no puede ser nulo")
    @Pattern(regexp = "^(Masculino|Femenino|Otro)$", message = "El género debe ser 'Masculino', 'Femenino' u 'Otro'")
    private String genero;

    @NotBlank (message = "El rango no puede estar en blanco")
    @Pattern(regexp = "^(Novato|Aprendiz|Crack Laboral|Maestro Laboral|Gurú Laboral|Leyenda Laboral)$", message = "Valor de rango no válido")
    private String rango;

    @NotBlank
    private static final List<String> regionesDisponibles = Arrays.asList(
            "Región de Arica y Parinacota",
            "Región de Tarapacá",
            "Región de Antofagasta",
            "Región de Atacama",
            "Región de Coquimbo",
            "Región de Valparaíso",
            "Región Metropolitana de Santiago",
            "Región del Libertador General Bernardo O'Higgins",
            "Región de Maule",
            "Región de Ñuble",
            "Región del Biobío",
            "Región de La Araucanía",
            "Región de Los Ríos",
            "Región de Los Lagos",
            "Región de Aysén del General Carlos Ibáñez del Campo",
            "Región de Magallanes y de la Antártica Chilena");}