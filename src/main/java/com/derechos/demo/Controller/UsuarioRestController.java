package com.derechos.demo.Controller;

import com.derechos.demo.DTO.LoginDTO;
import com.derechos.demo.DTO.UsuarioDTO;
import com.derechos.demo.Model.Usuario;
import com.derechos.demo.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> listaUsuarios = usuarioService.TodosLosUsuarios();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioSeleccionado = usuarioService.buscarUsuarioPorId(id);
        return usuarioSeleccionado
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/nuevo")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id) {
        usuarioService.borrarUsuarioPorId(id);
        return new ResponseEntity<>("El usuario fue eliminado", HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario, @PathVariable Long id) {
        Optional<Usuario> usuarioEditado = usuarioService.editarUsuarioPorId(id, usuario);
        return usuarioEditado
                .map(usuarioResponse -> new ResponseEntity<>(usuarioResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
