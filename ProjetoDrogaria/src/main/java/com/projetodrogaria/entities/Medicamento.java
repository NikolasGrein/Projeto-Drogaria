package com.projetodrogaria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "Medicamento")
public class Medicamento {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 4, max = 50, message = "O número de caracteres deve estar entre 4 ou 50 letras.")
    @Column(name = "nome")
    private String nome;
    
    @Size(min = 10, max = 100)
    @Column(name = "bula")
    private String bula;
    
    @Future(message = "A data é inferior a atual.")
    @Column(name = "dataValidade")
    private int dataValidade;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getBula() {
        return bula;
    }
    public void setBula(String bula) {
        this.bula = bula;
    }
    
    public int getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(int dataValidade) {
        this.dataValidade = dataValidade;
    }

}
