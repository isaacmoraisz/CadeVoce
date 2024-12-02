package com.example.CadeVoce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

@Repository
public class PessoaDesaparecidaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    // Inserir nova pessoa desaparecida no banco de dados
    public void inserirPessoaDesaparecida(PessoaDesaparecida pessoa) {
        String sql = "INSERT INTO pessoa_desaparecida(nome, idade, ultima_localizacao, descricao) VALUES(?, ?, ?, ?)";
        jdbc.update(sql, pessoa.getNome(), pessoa.getIdade(), pessoa.getUltimaLocalizacao(), pessoa.getDescricao());
    }

    // Listar todas as pessoas desaparecidas
    public List<PessoaDesaparecida> obterPessoasDesaparecidas() {
        String sql = "SELECT * FROM pessoa_desaparecida;";
        List<Map<String, Object>> registros = jdbc.queryForList(sql); // essa linha está chamando os registros do banco de dados
        ArrayList<PessoaDesaparecida> aux = new ArrayList<>();
        for (Map<String, Object> reg : registros) {
            aux.add(converter(reg));
        }
        return aux;
    }

    // Pegar uma pessoa desaparecida por ID
    public PessoaDesaparecida pegarPessoaDesaparecida(int id) {
        String sql = "SELECT * FROM pessoa_desaparecida WHERE id = ?";
        return converter(jdbc.queryForMap(sql, id)); // Executa a query passando o ID para "?"
    }

    // Atualizar os dados de uma pessoa desaparecida
    public void atualizarPessoaDesaparecida(int id, PessoaDesaparecida novaPessoa) {
        String sql = "UPDATE pessoa_desaparecida SET nome = ?, idade = ?, ultima_localizacao = ?, descricao = ? WHERE id = ?";
        jdbc.update(sql, novaPessoa.getNome(), novaPessoa.getIdade(), novaPessoa.getUltimaLocalizacao(), novaPessoa.getDescricao(), id);
    }

    // Deletar uma pessoa desaparecida pelo ID
    public void deletarPessoaDesaparecida(int id) {
        String sql = "DELETE FROM pessoa_desaparecida WHERE id = ?";
        jdbc.update(sql, id);
    }

    // Método para converter os dados do banco de dados para o modelo PessoaDesaparecida
    private PessoaDesaparecida converter(Map<String, Object> registro) {
        PessoaDesaparecida pessoa = new PessoaDesaparecida();
        pessoa.setId((Integer) registro.get("id"));
        pessoa.setNome((String) registro.get("nome"));
        pessoa.setIdade((Integer) registro.get("idade"));
        pessoa.setUltimaLocalizacao((String) registro.get("ultima_localizacao"));
        pessoa.setDescricao((String) registro.get("descricao"));
        return pessoa;
    }
}
