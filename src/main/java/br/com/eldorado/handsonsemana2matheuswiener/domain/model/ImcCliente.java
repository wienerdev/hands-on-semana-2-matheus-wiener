package br.com.eldorado.handsonsemana2matheuswiener.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("imc-cliente")
public class ImcCliente {

    @Id
    private UUID idImc;
    private UUID idCliente;
    private float peso;
    private float altura;
    private LocalDate data;
    private float imc;

}
