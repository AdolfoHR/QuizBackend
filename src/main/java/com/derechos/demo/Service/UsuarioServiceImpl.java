package com.derechos.demo.Service;

import com.derechos.demo.DTO.UsuarioDTO;
import com.derechos.demo.Model.Usuario;
import com.derechos.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByUsername(nombre);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> TodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> editarUsuarioPorId(Long id, Usuario nuevoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            // Realizar las actualizaciones necesarias en el usuario existente
            usuario.setUsername(nuevoUsuario.getUsername());
            usuario.setApellidoUsuario(nuevoUsuario.getApellidoUsuario());
            // Agregar más campos según sea necesario

            return Optional.of(usuarioRepository.save(usuario));
        }

        return Optional.empty(); // Devolver un Optional vacío si el usuario no existe
    }

    @Override
    public Optional<Usuario> editarUsuarioPorNombre(String nombre, Usuario nuevoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(nombre);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            // Realizar las actualizaciones necesarias en el usuario existente
            usuario.setApellidoUsuario(nuevoUsuario.getApellidoUsuario());
            // Agregar más campos según sea necesario

            return Optional.of(usuarioRepository.save(usuario));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Usuario> editarUsuarioPorUsername(String username, Usuario nuevoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(username);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            // Realizar las actualizaciones necesarias en el usuario existente
            usuario.setUsername(nuevoUsuario.getUsername());
            usuario.setApellidoUsuario(nuevoUsuario.getApellidoUsuario());
            // Agregar más campos según sea necesario

            return Optional.of(usuarioRepository.save(usuario));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Usuario> editarUsuarioPorEmail(String email, Usuario nuevoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(email);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            // Realizar las actualizaciones necesarias en el usuario existente
            usuario.setUsername(nuevoUsuario.getUsername());
            usuario.setApellidoUsuario(nuevoUsuario.getApellidoUsuario());
            // Agregar más campos según sea necesario

            return Optional.of(usuarioRepository.save(usuario));
        }

        return Optional.empty();
    }

    @Override
    public void borrarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void borrarUsuarioPorNombre(String nombre) {
        usuarioRepository.deleteByUsername(nombre);
    }

    @Override
    public void borrarUsuarioPorUsername(String username) {
        usuarioRepository.deleteByUsername(username);
    }

    @Override
    public void borrarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    @Override
    public boolean existeUsuarioPorUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    public boolean existeUsuarioPorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Optional<UsuarioDTO> obtenerUsuarioDTO(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        return usuario.map(u -> UsuarioDTO.builder()
                .username(u.getUsername())
                .apellidoUsuario(u.getApellidoUsuario())
                .email(u.getEmail())
                .genero(u.getGenero())
                .rango(u.getRango())
                .build());
    }
}
