package br.com.eldorado.handsonsemana2matheuswiener.dto;

import br.com.eldorado.handsonsemana2matheuswiener.domain.enums.ClassificacaoImc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ImcClienteResponseDto {

    List<ImcClienteDto> imcCliente = new ArrayList<>();
    ClassificacaoImc classificacaoImcAtual;
    ClienteDto dadosCliente;
}
