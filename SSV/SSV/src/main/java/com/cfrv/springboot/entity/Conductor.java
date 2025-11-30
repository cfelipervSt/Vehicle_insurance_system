package com.cfrv.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "Conductor")
public class Conductor {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conductor")
    private Long idConductor;

    @Setter
    @Getter
    @Column(name = "nombre", nullable = false)
    private String Nombre;

    @Setter
    @Getter
    @Column(name = "licencia", nullable = false, length = 15)
    private String Licencia;

    @Setter
    @Getter
    @Column(name = "telefono", nullable = false, length = 15)
    private String Telefono;

    @Setter
    @Getter
    @Column(name = "direccion", nullable = false, length = 20)
    private String Direccion;

    @Getter
    @Setter
    @Column(name = "activo")
    private Boolean Activo;

    @Getter
    @Setter
    @OneToOne(mappedBy = "conductor")
    private Vehiculo vehiculo;


    public boolean isActivo() {
        return Activo;
    }

}

