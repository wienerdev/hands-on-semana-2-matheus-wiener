package br.com.eldorado.handsonsemana2matheuswiener.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteDto {

    private UUID id;
    private String nome;
    private String genero;
    private String rg;
    private Integer frequenciaMensal;
    private String telefone;
    private String endereco;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dtNascimento;
}
