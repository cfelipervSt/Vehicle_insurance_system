package com.cfrv.springboot.repositories;

import com.cfrv.springboot.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {
    List<Seguro> findByVehiculo_IdVehiculo(Long idVehiculo);
}

