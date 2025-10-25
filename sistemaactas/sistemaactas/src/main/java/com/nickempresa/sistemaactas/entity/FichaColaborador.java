package com.nickempresa.sistemaactas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FichaColaborador")
@Data
public class FichaColaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dni;
    private String nombres;
    private String apellidos;

    @Column(name = "area_funcional")
    private String areaFuncional;

    private String cecos;
    private String sede;
    private String correo;
    private String cargo;
    private String estado;

    @OneToMany(mappedBy = "colaborador")
    private Set<com.example.gestionactas.entity.Acta> actas = new HashSet<>();


}
