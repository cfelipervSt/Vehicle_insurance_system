package com.cfrv.springboot.service.implementacion;

import com.cfrv.springboot.entity.Vehiculo;
import com.cfrv.springboot.repositories.VehiculoRepository;
import com.cfrv.springboot.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehicleService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> buscarPorId(Long idVehiculo) {
        return vehiculoRepository.findById(idVehiculo);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }

    @Override
    public Vehiculo actualizarVehiculo(Long idVehiculo, Vehiculo vehiculo) {
        Vehiculo existente = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new RuntimeException("Vehiculo con ID " + idVehiculo + " no existe"));

        existente.setPlaca(vehiculo.getPlaca());
        existente.setMarca(vehiculo.getMarca());
        existente.setModelo(vehiculo.getModelo());
        existente.setAno(vehiculo.getAno());
        existente.setColor(vehiculo.getColor());

        return vehiculoRepository.save(existente);
    }

    @Override
    public void eliminarVehiculo(Long idVehiculo) {
        vehiculoRepository.deleteById(idVehiculo);
    }
}