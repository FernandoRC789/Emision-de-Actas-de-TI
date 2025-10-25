package com.example.gestionactas.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acta")
public class Acta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_acta", nullable = false)
    private String codigoActa;

    @ManyToOne
    @JoinColumn(name = "tipo_acta_id", nullable = false)
    private TipoActa tipoActa;

    @ManyToOne
    @JoinColumn(name = "ficha_colaborador_id", nullable = false)
    private FichaColaborador colaborador;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision = LocalDateTime.now();

    @Column(length = 1000)
    private String observaciones;

    @Column(name = "pdf_url", length = 500)
    private String pdfUrl;

    @Column(length = 50)
    private String estado = "GENERADA";

    @ManyToMany
    @JoinTable(
            name = "acta_activo",
            joinColumns = @JoinColumn(name = "acta_id"),
            inverseJoinColumns = @JoinColumn(name = "activo_id")
    )
    private Set<ActivoTecnologico> activos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "acta_firma",
            joinColumns = @JoinColumn(name = "acta_id"),
            inverseJoinColumns = @JoinColumn(name = "firma_id")
    )
    private Set<Firma> firmas = new HashSet<>();

    // Getters y Setters
    // ...
}
