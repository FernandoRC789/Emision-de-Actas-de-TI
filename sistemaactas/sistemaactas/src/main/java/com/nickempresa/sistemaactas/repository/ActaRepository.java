package com.nickempresa.sistemaactas.repository;

import com.example.gestionactas.entity.Acta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActaRepository extends JpaRepository<Acta, Long> { }

