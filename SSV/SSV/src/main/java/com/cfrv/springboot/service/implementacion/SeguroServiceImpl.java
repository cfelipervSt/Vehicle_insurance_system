package com.cfrv.springboot.service.implementacion;

import com.cfrv.springboot.entity.Seguro;
import com.cfrv.springboot.repositories.SeguroRepository;
import com.cfrv.springboot.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    public Seguro registrarSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

    @Override
    public List<Seguro> listarSeguros() {
        return seguroRepository.findAll();
    }

    @Override
    public Optional<Seguro> buscarPorId(Long idSeguro) {
        return seguroRepository.findById(idSeguro);
    }

    @Override
    public Seguro actualizarSeguro(Long idSeguro, Seguro seguro) {

        Seguro existente = seguroRepository.findById(idSeguro)
                .orElseThrow(() -> new RuntimeException(
                        "Seguro con ID " + idSeguro + " no existe"));

        existente.setCompania(seguro.getCompania());
        existente.setNumeroPoliza(seguro.getNumeroPoliza());
        existente.setFechaInicio(seguro.getFechaInicio());
        existente.setFechaVencimiento(seguro.getFechaVencimiento());
        existente.setVehiculo(seguro.getVehiculo());

        return seguroRepository.save(existente);
    }

    @Override
    public void eliminarSeguro(Long idSeguro) {
        seguroRepository.deleteById(idSeguro);
    }


    public List<Seguro> obtenerSegurosPorVehiculo(Long idVehiculo){
        return seguroRepository.findByVehiculo_IdVehiculo(idVehiculo);
    }
}

