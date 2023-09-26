package com.projetodrogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodrogaria.entities.Medicamento;
import com.projetodrogaria.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Medicamento> buscaMedicamentoControlId(@PathVariable Long id) {
        Medicamento medicamento = medicamentoService.buscaMedicamentoPorId(id);
        if (medicamento != null) {
            return ResponseEntity.ok(medicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> buscaTodosMedicamentosControl() {
        List<Medicamento> medicamentos = medicamentoService.buscaTodosMedicamentos();
        return ResponseEntity.ok(medicamentos);
    }

    @PostMapping("/")
    public ResponseEntity<Medicamento> salvaMedicamentoControl(@RequestBody Medicamento medicamento) {
        Medicamento salvaMedicamento = medicamentoService.salvaMedicamento(medicamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaMedicamento);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Medicamento> alteraMedicamentoControl(@PathVariable Long codigo, @RequestBody Medicamento medicamento) {
        Medicamento alteraMedicamento = medicamentoService.alterarMedicamento(codigo, medicamento);
        if (alteraMedicamento != null) {
            return ResponseEntity.ok(medicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaMedicamentoControl(@PathVariable Long codigo) {
        boolean apagar = medicamentoService.apagarMedicamento(codigo);
        if (apagar) {
            return ResponseEntity.ok().body("O Medicamento foi excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}