package com.example.CadeVoce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CadeVoce.model.PessoaDesaparecida;
import com.example.CadeVoce.service.PessoaDesaparecidaService;

@Controller
public class PessoaDesaparecidaController {

    @Autowired
    private PessoaDesaparecidaService pessoaDesaparecidaService;

    @GetMapping("/")
    public String cadastro(Model model) {
        PessoaDesaparecida pessoa = new PessoaDesaparecida(); // Cria nova pessoa
        model.addAttribute("pessoa", pessoa);
        return "cadastro"; // Nome do template HTML
    }

    // Processar cadastro de nova pessoa
    @PostMapping("/cadastro")
    public String sucesso(@ModelAttribute PessoaDesaparecida pessoa) {
        pessoaDesaparecidaService.inserirPessoaDesaparecida(pessoa); // Chama o serviço para salvar
        return "sucesso"; // Página de sucesso
    }

    // Listar todas as pessoas desaparecidas
    @GetMapping("/lista")
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaDesaparecidaService.obterPessoasDesaparecidas());
        return "lista"; // Nome do template HTML para exibir a lista
    }

    // Exibir formulário para atualizar os dados de uma pessoa
    @GetMapping("/atualizar/{id}")
    public String atualizar(Model model, @PathVariable("id") int id) {
        PessoaDesaparecida pessoa = pessoaDesaparecidaService.pegarPessoaDesaparecida(id);
        model.addAttribute("pessoa", pessoa);
        return "atualizar"; // Nome do template HTML
    }

    // Atualizar pessoa desaparecida
    @PostMapping("/atualizar/{id}")
    public String atualizarPessoa(@ModelAttribute PessoaDesaparecida pessoa, @PathVariable("id") int id) {
        pessoaDesaparecidaService.atualizarPessoaDesaparecida(id, pessoa);
        return "redirect:/lista"; // Redireciona para a lista
    }

    // Deletar pessoa desaparecida
    @PostMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable("id") int id) {
        pessoaDesaparecidaService.deletarPessoaDesaparecida(id);
        return "redirect:/lista"; // Redireciona para a lista
    }
}

