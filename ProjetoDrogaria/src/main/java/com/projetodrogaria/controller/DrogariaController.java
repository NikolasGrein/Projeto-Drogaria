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

import com.projetodrogaria.entities.Drogaria;
import com.projetodrogaria.service.DrogariaService;

@RestController
@RequestMapping("/drogaria")
public class DrogariaController {

    private final DrogariaService drogariaService;

    @Autowired
    public DrogariaController(DrogariaService drogariaService) {
        this.drogariaService = drogariaService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Drogaria> buscaDrogariaControlId(@PathVariable Long id) {
        Drogaria drogaria = drogariaService.buscaDrogariaPorId(id); 
        if (drogaria != null) {
            return ResponseEntity.ok(drogaria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Drogaria>> buscaTodosDrogariasControl() { 
        List<Drogaria> drogarias = drogariaService.buscaTodosDrogarias(); 
        return ResponseEntity.ok(drogarias);
    }

    @PostMapping("/")
    public ResponseEntity<Drogaria> salvaDrogariaControl(@RequestBody Drogaria drogaria) { 
        Drogaria salvaDrogaria = drogariaService.salvaDrogaria(drogaria); 
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaDrogaria);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Drogaria> alteraDrogariaControl(@PathVariable Long codigo, @RequestBody Drogaria drogaria) {
        Drogaria alteraDrogaria = drogariaService.alterarDrogaria(codigo, drogaria); 
        if (alteraDrogaria != null) {
            return ResponseEntity.ok(drogaria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaDrogariaControl(@PathVariable Long codigo) {
        boolean apagar = drogariaService.apagarDrogaria(codigo);
        if (apagar) {
            return ResponseEntity.ok().body("A Drogaria foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}