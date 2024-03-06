package com.derechos.demo.DTO;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Set;

@Data
public class RegistroDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @Size(min = 3, max = 15)
    private String apellidoUsuario;

    @Min(value = 1, message = "Tienes que indicar un número mayor a 1")
    @Max(value = 10, message = "Tienes que indicar un número menor a 10")
    private Integer aniosUsuario;

    private String fotoPerfil;
}

