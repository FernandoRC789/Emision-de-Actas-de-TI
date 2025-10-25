package com.example.gestionactas.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "firma")
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "persona_tipo", nullable = false)
    private String personaTipo; // COLABORADOR o TI

    @Column(name = "persona_id")
    private Long personaId;

    @Lob
    @Column(name = "imagen_base64")
    private String imagenBase64;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    // Getters y Setters
}
