package com.nickempresa.sistemaactas.repository;

import com.nickempresa.sistemaactas.entity.ReporteActas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<ReporteActas, Long> {

}
