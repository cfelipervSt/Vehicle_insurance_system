package com.cfrv.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class Vehiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    // --- Atributos ---
    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private int ano;

    @Column(name = "color", length = 30)
    private String color;

    @OneToOne
    @JoinColumn(name = "id_conductor")
    private Conductor conductor;

    @JsonManagedReference
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Seguro> seguros;


    public Vehiculo(Long idVehiculo, String placa, String marca, String modelo, int ano, String color) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        if (ano != vehiculo.ano) return false;
        if (idVehiculo != null ? !idVehiculo.equals(vehiculo.idVehiculo) : vehiculo.idVehiculo != null) return false;
        if (placa != null ? !placa.equals(vehiculo.placa) : vehiculo.placa != null) return false;
        if (marca != null ? !marca.equals(vehiculo.marca) : vehiculo.marca != null) return false;
        if (modelo != null ? !modelo.equals(vehiculo.modelo) : vehiculo.modelo != null) return false;
        return color != null ? color.equals(vehiculo.color) : vehiculo.color == null;
    }


    @Override
    public int hashCode() {
        int result = idVehiculo != null ? idVehiculo.hashCode() : 0;
        result = 31 * result + (placa != null ? placa.hashCode() : 0);
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + ano;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", color='" + color + '\'' +
                '}';
    }
}
