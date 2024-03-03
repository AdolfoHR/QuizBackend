package com.derechos.demo.Service;

import com.derechos.demo.DTO.UsuarioDTO;
import com.derechos.demo.Model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);

    Optional<Usuario> buscarUsuarioPorId(Long id);

    Optional<Usuario> buscarUsuarioPorNombre(String nombre);

    Optional<Usuario> buscarUsuarioPorUsername(String username);

    Optional<Usuario> buscarUsuarioPorEmail(String email);

    List<Usuario> TodosLosUsuarios();

    Optional<Usuario> editarUsuarioPorId(Long id, Usuario nuevoUsuario);

    Optional<Usuario> editarUsuarioPorNombre(String nombre, Usuario nuevoUsuario);

    Optional<Usuario> editarUsuarioPorUsername(String username, Usuario nuevoUsuario);

    Optional<Usuario> editarUsuarioPorEmail(String email, Usuario nuevoUsuario);

    void borrarUsuarioPorId(Long id);

    void borrarUsuarioPorNombre(String nombre);

    void borrarUsuarioPorUsername(String username);

    void borrarUsuarioPorEmail(String email);

    boolean existeUsuarioPorUsername(String username);

    boolean existeUsuarioPorEmail(String email);

    void guardarUsuario(Usuario usuario);

    Optional<UsuarioDTO> obtenerUsuarioDTO(String email);
}
