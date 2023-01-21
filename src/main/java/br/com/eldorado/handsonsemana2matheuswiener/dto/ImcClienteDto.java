package br.com.eldorado.handsonsemana2matheuswiener.dto;

import br.com.eldorado.handsonsemana2matheuswiener.domain.enums.ClassificacaoImc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ImcClienteDto {

    private UUID idImc;
    private UUID idCliente;
    private float peso;
    private float altura;
    private float imc;
    private ClassificacaoImc classificacao;
}
