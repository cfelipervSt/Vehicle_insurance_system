package com.cfrv.springboot.service;

import com.cfrv.springboot.entity.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {

    Conductor registrarConductor(Conductor conductor);

    List<Conductor> listarConductores();

    Optional<Conductor> buscarPorId(Long id);

    Conductor actualizarConductor(Long id, Conductor conductor);

    void eliminarConductor(Long id);
}

