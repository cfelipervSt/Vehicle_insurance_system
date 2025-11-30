package com.cfrv.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
@Table(name = "seguro")
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguro")
    private Long idSeguro;

    @Column(name = "compania", nullable = false)
    private String compania;

    @Column(name = "numero_poliza", nullable = false, length = 15)
    private String numeroPoliza;

    @Column(name = "fecha_inicio", nullable = false)
    private String fechaInicio;

    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimiento;

    // MUCHOS seguros pueden pertenecer a UN vehiculo
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

}

