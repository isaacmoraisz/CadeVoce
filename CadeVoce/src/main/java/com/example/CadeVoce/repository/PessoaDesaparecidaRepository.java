package com.example.CadeVoce.repository;

import com.example.CadeVoce.model.PessoaDesaparecida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PessoaDesaparecidaRepository extends JpaRepository<PessoaDesaparecida, Integer> {
    List<PessoaDesaparecida> findByCidadeDesaparecimento(String cidadeDesaparecimento);
}
