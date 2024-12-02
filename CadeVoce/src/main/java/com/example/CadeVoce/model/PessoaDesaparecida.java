package com.example.CadeVoce.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PessoaDesaparecida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private int idade;
    private String ultimaLocalizacao;
    private String descricao;

    private LocalDate dataDesaparecimento; // Armazena apenas a data do desaparecimento

    // Construtor sem parâmetros
    public PessoaDesaparecida() {
    }

    // Construtor com todos os parâmetros
    public PessoaDesaparecida(int id, String nome, int idade, String ultimaLocalizacao, String descricao, LocalDate dataDesaparecimento) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.ultimaLocalizacao = ultimaLocalizacao;
        this.descricao = descricao;
        this.dataDesaparecimento = dataDesaparecimento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getUltimaLocalizacao() {
        return ultimaLocalizacao;
    }

    public void setUltimaLocalizacao(String ultimaLocalizacao) {
        this.ultimaLocalizacao = ultimaLocalizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDesaparecimento() {
        return dataDesaparecimento;
    }

    public void setDataDesaparecimento(LocalDate dataDesaparecimento) {
        this.dataDesaparecimento = dataDesaparecimento;
    }
}
