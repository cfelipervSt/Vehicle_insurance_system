package com.cfrv.springboot.service.implementacion;

import com.cfrv.springboot.entity.Conductor;
import com.cfrv.springboot.repositories.ConductorRepository;
import com.cfrv.springboot.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public Conductor registrarConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> listarConductores() {
        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> buscarPorId(Long id) {
        return conductorRepository.findById(id);
    }

    @Override
    public Conductor actualizarConductor(Long id, Conductor conductor) {

        Conductor existente = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Conductor con ID " + id + " no existe"));

        existente.setNombre(conductor.getNombre());
        existente.setLicencia(conductor.getLicencia());
        existente.setTelefono(conductor.getTelefono());
        existente.setDireccion(conductor.getDireccion());
        existente.setActivo(conductor.isActivo());

        // Si se envía un vehículo relacionado desde el controller, ya vendrá seteado.
        existente.setVehiculo(conductor.getVehiculo());

        return conductorRepository.save(existente);
    }

    @Override
    public void eliminarConductor(Long id) {
        conductorRepository.deleteById(id);
    }
}
