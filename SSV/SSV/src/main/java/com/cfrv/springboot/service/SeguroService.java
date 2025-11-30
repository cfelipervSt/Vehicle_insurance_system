package com.cfrv.springboot.service;

import com.cfrv.springboot.entity.Seguro;

import java.util.List;
import java.util.Optional;

public interface SeguroService {

    Seguro registrarSeguro(Seguro seguro);

    List<Seguro> listarSeguros();

    Optional<Seguro> buscarPorId(Long idSeguro);

    Seguro actualizarSeguro(Long idSeguro, Seguro seguro);

    void eliminarSeguro(Long idSeguro);

    List<Seguro> obtenerSegurosPorVehiculo(Long idVehiculo);
}

