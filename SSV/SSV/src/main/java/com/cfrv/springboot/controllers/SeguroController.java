package com.cfrv.springboot.controllers;

import com.cfrv.springboot.entity.Seguro;
import com.cfrv.springboot.entity.Vehiculo;
import com.cfrv.springboot.service.SeguroService;
import com.cfrv.springboot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguros")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @Autowired
    private VehicleService vehiculoService;

    // LISTAR TODOS LOS SEGUROS
    @GetMapping("/get")
    public List<Seguro> listar() {
        return seguroService.listarSeguros();
    }

    // CREAR SEGURO (asignarlo a un vehículo)
    @PostMapping("/register")
    public Seguro crear(@RequestBody Seguro seguro) {

        // Validar y establecer el vehículo relacionado
        if (seguro.getVehiculo() != null &&
                seguro.getVehiculo().getIdVehiculo() != null) {

            Vehiculo vehiculo = vehiculoService
                    .buscarPorId(seguro.getVehiculo().getIdVehiculo())
                    .orElseThrow(() ->
                            new RuntimeException("Vehículo no encontrado"));

            seguro.setVehiculo(vehiculo);
        }

        return seguroService.registrarSeguro(seguro);
    }

    // BUSCAR SEGURO POR ID
    @GetMapping("/{id}")
    public Seguro obtener(@PathVariable Long id) {
        return seguroService.buscarPorId(id).orElse(null);
    }

    // ACTUALIZAR SEGURO
    @PutMapping("/{id}")
    public Seguro actualizar(@PathVariable Long id,
                             @RequestBody Seguro seguro) {

        if (seguro.getVehiculo() != null &&
                seguro.getVehiculo().getIdVehiculo() != null) {

            Vehiculo vehiculo = vehiculoService
                    .buscarPorId(seguro.getVehiculo().getIdVehiculo())
                    .orElseThrow(() ->
                            new RuntimeException("Vehículo no encontrado"));

            seguro.setVehiculo(vehiculo);
        }

        return seguroService.actualizarSeguro(id, seguro);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        seguroService.eliminarSeguro(id);
    }

    @GetMapping("/vehiculo/{id}")
    public List<Seguro> obtenerSegurosPorVehiculo(@PathVariable Long id){
        return seguroService.obtenerSegurosPorVehiculo(id);
    }


}

