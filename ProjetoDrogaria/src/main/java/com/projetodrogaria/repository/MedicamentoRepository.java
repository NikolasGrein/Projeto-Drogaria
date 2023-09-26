package com.projetodrogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodrogaria.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

}
