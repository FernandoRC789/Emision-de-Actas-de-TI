package com.nickempresa.sistemaactas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ActivoTecnologico")
@Data
public class ActivoTecnologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_interno")
    private String codigoInterno;

    private String tipo;
    private String marca;
    private String modelo;

    @Column(name = "numero_serie")
    private String numeroSerie;

    private String estado;
    private String observaciones;

    @ManyToMany(mappedBy = "activos")
    private Set<com.example.gestionactas.entity.Acta> actas = new HashSet<>();

}
