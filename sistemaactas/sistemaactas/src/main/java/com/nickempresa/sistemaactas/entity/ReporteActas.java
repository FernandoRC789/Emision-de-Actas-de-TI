package com.nickempresa.sistemaactas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reporte_actas")
@Data
public class ReporteActas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion;

    @Column(name = "filtros_usados")
    private String filtrosUsados;

    @Column(name = "url_reporte")
    private String urlReporte;

    @PrePersist
    public void prePersist() {
        if (fechaGeneracion == null) fechaGeneracion = LocalDateTime.now();
    }
}
