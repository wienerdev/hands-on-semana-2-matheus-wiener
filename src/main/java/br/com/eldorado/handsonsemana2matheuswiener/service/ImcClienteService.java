package br.com.eldorado.handsonsemana2matheuswiener.service;

import br.com.eldorado.handsonsemana2matheuswiener.domain.enums.ClassificacaoImc;
import br.com.eldorado.handsonsemana2matheuswiener.domain.model.Cliente;
import br.com.eldorado.handsonsemana2matheuswiener.domain.model.ImcCliente;
import br.com.eldorado.handsonsemana2matheuswiener.domain.repository.ClienteRepository;
import br.com.eldorado.handsonsemana2matheuswiener.domain.repository.ImcClienteRepository;
import br.com.eldorado.handsonsemana2matheuswiener.dto.*;
import br.com.eldorado.handsonsemana2matheuswiener.dto.list.CustomImcClientList;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ImcClienteService {

    @Autowired
    private ImcClienteRepository imcRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper mapper;

    public ImcClienteDto saveImcCliente(ImcClienteDto dto) {
        dto.setIdImc(UUID.randomUUID());
        ImcCliente imcCliente = mapper.map(dto, ImcCliente.class);

        imcCliente.setData(LocalDate.now());
        imcCliente.setImc(calcularImcCliente(imcCliente.getPeso(), imcCliente.getAltura()));

        ImcCliente imcSaved = imcRepository.save(imcCliente);
        log.info("Imc Cliente salvo com sucesso {}", imcSaved);
        return mapper.map(imcSaved, ImcClienteDto.class);
    }

    public List<ImcClienteDto> getAllImc() {
        List<ImcCliente> imcClientes = imcRepository.findAll();
        return mapper.map(imcClientes, CustomImcClientList.class);
    }

    public ImcClienteResponseDto getAllImcByIdCliente(UUID idCliente) {
        List<ImcCliente> imcCliente = imcRepository.findByIdCliente(idCliente);
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        List<ImcClienteDto> clientesDto = mapper.map(imcCliente, CustomImcClientList.class);
        return ImcClienteResponseDto.builder()
                .imcCliente(clientesDto)
                .classificacaoImcAtual(retornarClassificacaoImcCliente(imcCliente))
                .dadosCliente(mapper.map(cliente, ClienteDto.class))
                .build();
    }

    public ImcClienteDto getImcById(UUID id) {
        Optional<ImcCliente> imcCliente = imcRepository.findById(id);
        return mapper.map(imcCliente, ImcClienteDto.class);
    }

    public String deleteById(UUID id) {
        try {
            imcRepository.deleteById(id);
            return "IMC do Cliente deletado com sucesso!";
        } catch (Exception e) {
            return "Ocorreu algum erro ao deletar o IMC do cliente: " + Arrays.toString(e.getStackTrace());
        }
    }

    private float calcularImcCliente(float peso, float altura) {
        return peso / (altura * altura);
    }

    private ClassificacaoImc retornarClassificacaoImcCliente(List<ImcCliente> clientesDto) {
        ImcCliente cliente = clientesDto.stream().skip(clientesDto.stream().count() - 1).findFirst().get();
        if (cliente.getImc() <= 18.5) {
            return ClassificacaoImc.MAGREZA;
        } else if (cliente.getImc() <= 24.9) {
            return ClassificacaoImc.NORMAL;
        } else if (cliente.getImc() <= 29.9) {
            return ClassificacaoImc.SOBREPESO;
        } else if (cliente.getImc() <= 39.9) {
            return ClassificacaoImc.OBESIDADE;
        } else {
            return ClassificacaoImc.OBESIDADE_GRAVE;
        }
    }
}
