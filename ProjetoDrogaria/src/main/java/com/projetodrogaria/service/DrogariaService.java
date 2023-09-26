package com.projetodrogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodrogaria.entities.Drogaria;
import com.projetodrogaria.repository.DrogariaRepository;

@Service
public class DrogariaService {
	private final DrogariaRepository drogariaRepository;

    @Autowired
    public DrogariaService(DrogariaRepository drogariaRepository) {
        this.drogariaRepository = drogariaRepository;
    }

    public List<Drogaria> buscaTodosDrogarias() {
        return drogariaRepository.findAll();
    }

    public Drogaria buscaDrogariaPorId(Long id) {
        Optional<Drogaria> drogaria = drogariaRepository.findById(id);
        return drogaria.orElse(null);
    }

    public Drogaria salvaDrogaria(Drogaria drogaria) {
        return drogariaRepository.save(drogaria);
    }

    public Drogaria alterarDrogaria(Long id, Drogaria alterarDrogaria) {
        Optional<Drogaria> existeDrogaria = drogariaRepository.findById(id);
        if (existeDrogaria.isPresent()) {
            alterarDrogaria.setId(id);
            return drogariaRepository.save(alterarDrogaria);
        }
        return null;
    }

    public boolean apagarDrogaria(Long codigo) {
        Optional<Drogaria> existeDrogaria = drogariaRepository.findById(codigo);
        if (existeDrogaria.isPresent()) {
        	drogariaRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}


