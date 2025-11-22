package com.cfrv.springboot.controllers;

import com.cfrv.springboot.entity.Vehiculo;
import com.cfrv.springboot.repositories.VehiculoRepository;
import com.cfrv.springboot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VehicleController {

    @Autowired
    private VehicleService vehiculoService;

    @GetMapping({"/get"})
    public List<Vehiculo> listar() {
        return vehiculoService.listarVehiculos();
    }

    @PostMapping({"/register"})
    public Vehiculo crear(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.registrarVehiculo(vehiculo);
    }

    @GetMapping("/{id}")
    public Vehiculo obtener(@PathVariable Long id) {
        return vehiculoService.buscarPorId(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Vehiculo actualizar(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        return vehiculoService.actualizarVehiculo(id, vehiculo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
    }
}

