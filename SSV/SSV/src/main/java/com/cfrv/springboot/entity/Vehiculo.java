package com.cfrv.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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


    public Vehiculo() {

    }

    public Vehiculo(Long idVehiculo, String placa, String marca, String modelo, int ano, String color) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.color = color;
    }


    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
