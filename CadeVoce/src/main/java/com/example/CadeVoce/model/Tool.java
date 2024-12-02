package com.example.CadeVoce.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Tool {

    // Converter o Map em uma instância de PessoaDesaparecida
    public static PessoaDesaparecida converter(Map<String, Object> registro) {
        // Extrair a dataDesaparecimento como String e convertê-la para LocalDate
        LocalDate dataDesaparecimento = null;
        if (registro.get("data_desaparecimento") != null) {
            dataDesaparecimento = LocalDate.parse((String) registro.get("data_desaparecimento"), DateTimeFormatter.ISO_DATE);
        }

        return new PessoaDesaparecida(
                (Integer) registro.get("id"), 
                (String) registro.get("nome"),
                (Integer) registro.get("idade"),
                (String) registro.get("ultima_localizacao"),
                (String) registro.get("descricao"),
                dataDesaparecimento // Passa a data para o construtor
        );
    }
}
