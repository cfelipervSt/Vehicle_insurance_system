package com.cfrv.springboot.service;

import com.cfrv.springboot.entity.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Vehiculo registrarVehiculo(Vehiculo vehiculo);

    List<Vehiculo> listarVehiculos();

    Optional<Vehiculo> buscarPorId(Long idVehiculo);

    Optional<Vehiculo> buscarPorPlaca(String placa);

    Vehiculo actualizarVehiculo(Long idVehiculo, Vehiculo vehiculo);

    void eliminarVehiculo(Long idVehiculo);
}

