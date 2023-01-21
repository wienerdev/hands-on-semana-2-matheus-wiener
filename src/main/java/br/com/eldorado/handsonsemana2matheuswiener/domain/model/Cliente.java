package br.com.eldorado.handsonsemana2matheuswiener.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("cliente")
public class Cliente {

    @Id
    private UUID id;
    private String nome;
    private String genero;
    private String rg;
    private LocalDate dtNascimento;
    private Integer frequenciaMensal;
    private String telefone;
    private String endereco;

}
