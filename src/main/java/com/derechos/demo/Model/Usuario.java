package com.derechos.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long Id;

    @Size(max = 20)
    @Column(unique = true)
    private String username;

    @Column(name = "apellido_usuario")
    @Size(min = 3, max = 15)
    private String apellidoUsuario;

    @Column(name = "edad_usuario")
    @Min(value = 1, message = "Tienes que indicar un número mayor a 1")
    @Max(value = 10, message = "Tienes que indicar un número menor a 10")
    private Integer aniosUsuario;

    @Size(max = 50)
    @Email(message = "No se introdujo un correo valido")
    @Column(unique = true)
    private String email;

    @Size(max = 120)
    private String password;

    private String fotoPerfil;


    @NotNull(message = "El género no puede ser nulo")
    @Pattern(regexp = "^(Masculino|Femenino|Otro)$", message = "El género debe ser 'Masculino', 'Femenino' u 'Otro'")
    private String genero;

    @NotBlank(message = "El rango no puede estar en blanco")
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
            "Región de Magallanes y de la Antártica Chilena");
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();


}