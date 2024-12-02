package com.example.CadeVoce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CadeVoce.model.PessoaDesaparecida;
import com.example.CadeVoce.repository.PessoaDesaparecidaRepository;

@Service
public class PessoaDesaparecidaService {

    @Autowired
    private PessoaDesaparecidaRepository pessoaDesaparecidaRepository;

    // Inserir uma nova pessoa desaparecida
    public void inserirPessoaDesaparecida(PessoaDesaparecida pessoa) {
        pessoaDesaparecidaRepository.save(pessoa); // Salva no banco de dados
    }

    // Obter todas as pessoas desaparecidas
    public List<PessoaDesaparecida> obterPessoasDesaparecidas() {
        return pessoaDesaparecidaRepository.findAll(); // Retorna a lista de pessoas desaparecidas
    }

    // Obter uma pessoa desaparecida por ID
    public PessoaDesaparecida pegarPessoaDesaparecida(int id) {
        Optional<PessoaDesaparecida> pessoaOptional = pessoaDesaparecidaRepository.findById(id);
        return pessoaOptional.orElse(null); // Retorna a pessoa, ou null se não encontrar
    }

    // Atualizar os dados de uma pessoa desaparecida
    public void atualizarPessoaDesaparecida(int id, PessoaDesaparecida novaPessoa) {
        if (pessoaDesaparecidaRepository.existsById(id)) { // Verifica se a pessoa existe
            novaPessoa.setId(id); // Define o ID da pessoa para garantir a atualização
            pessoaDesaparecidaRepository.save(novaPessoa); // Salva a pessoa atualizada
        }
    }

    // Deletar uma pessoa desaparecida por ID
    public void deletarPessoaDesaparecida(int id) {
        if (pessoaDesaparecidaRepository.existsById(id)) { // Verifica se a pessoa existe
            pessoaDesaparecidaRepository.deleteById(id); // Deleta a pessoa do banco
        }
    }
}

