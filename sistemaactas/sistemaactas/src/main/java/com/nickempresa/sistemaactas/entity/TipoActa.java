package com.nickempresa.sistemaactas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TipoActa")
@Data
public class TipoActa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;
    private String descripcion;

    @OneToMany(mappedBy = "tipoActa")
    private Set<com.example.gestionactas.entity.Acta> actas = new HashSet<>();

}