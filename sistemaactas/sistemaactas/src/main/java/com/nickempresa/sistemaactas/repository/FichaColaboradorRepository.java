package com.nickempresa.sistemaactas.repository;

import com.nickempresa.sistemaactas.entity.FichaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaColaboradorRepository extends JpaRepository<FichaColaborador, Integer> {
    List<FichaColaborador> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombre, String apellido);
    FichaColaborador findByDni(String dni);
}
