package com.projetodrogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodrogaria.entities.Medicamento;
import com.projetodrogaria.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
	private final MedicamentoRepository medicamentoRepository;

	@Autowired
	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	public List<Medicamento> buscaTodosMedicamentos() {
		return medicamentoRepository.findAll();
	}

	public Medicamento buscaMedicamentoPorId(Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		return medicamento.orElse(null);
	}

	public Medicamento salvaMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}

	public Medicamento alterarMedicamento(Long id, Medicamento alterarMedicamento) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			alterarMedicamento.setId(id);
			return medicamentoRepository.save(alterarMedicamento);
		}
		return null;
	}

	public boolean apagarMedicamento(Long codigo) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(codigo);
		if (existeMedicamento.isPresent()) {
			medicamentoRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}


