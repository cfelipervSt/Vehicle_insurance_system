package com.cfrv.springboot.controllers;

import com.cfrv.springboot.entity.Conductor;
import com.cfrv.springboot.entity.Vehiculo;
import com.cfrv.springboot.service.ConductorService;
import com.cfrv.springboot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private VehicleService vehiculoService;

    @GetMapping("/get")
    public List<Conductor> listar() {
        return conductorService.listarConductores();
    }

    @PostMapping("/register")
    public Conductor crear(@RequestBody Conductor conductor) {

        // Si viene un vehículo asignado
        if (conductor.getVehiculo() != null) {
            Vehiculo vehiculo = vehiculoService.buscarPorId(
                    conductor.getVehiculo().getIdVehiculo()
            ).orElse(null);

            conductor.setVehiculo(vehiculo);
        }

        return conductorService.registrarConductor(conductor);
    }

    @GetMapping("/{id}")
    public Conductor obtener(@PathVariable Long id) {
        return conductorService.buscarPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Conductor actualizar(@PathVariable Long id, @RequestBody Conductor conductor) {

        if (conductor.getVehiculo() != null) {
            Vehiculo vehiculo = vehiculoService.buscarPorId(
                    conductor.getVehiculo().getIdVehiculo()
            ).orElse(null);

            conductor.setVehiculo(vehiculo);
        }

        return conductorService.actualizarConductor(id, conductor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        conductorService.eliminarConductor(id);
    }
}

