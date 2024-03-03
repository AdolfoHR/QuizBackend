package com.derechos.demo.Service;

import com.derechos.demo.Model.ERol;
import com.derechos.demo.Model.Rol;
import com.derechos.demo.Repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public Optional<Rol> buscarRolPorNombre(ERol nombre) {
        return rolRepository.findByNombre(nombre);
    }}
