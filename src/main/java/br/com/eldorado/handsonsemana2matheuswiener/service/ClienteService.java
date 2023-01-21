package br.com.eldorado.handsonsemana2matheuswiener.service;

import br.com.eldorado.handsonsemana2matheuswiener.domain.model.Cliente;
import br.com.eldorado.handsonsemana2matheuswiener.domain.repository.ClienteRepository;
import br.com.eldorado.handsonsemana2matheuswiener.dto.ClienteDto;
import br.com.eldorado.handsonsemana2matheuswiener.dto.list.CustomClientList;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ModelMapper mapper;

    public ClienteDto saveCliente(ClienteDto dto) {
        dto.setId(UUID.randomUUID());
        Cliente cliente = mapper.map(dto, Cliente.class);
        Cliente clienteSaved = repository.save(cliente);
        log.info("CLiente salvo com sucesso {}", clienteSaved);

        return dto;
    }

    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = repository.findAll();
        return mapper.map(clientes, CustomClientList.class);
    }

    public ClienteDto getClienteById(UUID id) {
        Optional<Cliente> cliente = repository.findById(id);
        return mapper.map(cliente, ClienteDto.class);
    }

    public ClienteDto updateCliente(UUID id, ClienteDto dto) {
        dto.setId(id);
        Cliente cliente = mapper.map(dto, Cliente.class);
        repository.save(cliente);
        return dto;
    }

    public String deleteById(UUID id) {
        try {
            repository.deleteById(id);
            return "Cliente deletado com sucesso!";
        } catch (Exception e) {
            return "Ocorreu algum erro ao deletar o cliente: " + Arrays.toString(e.getStackTrace());
        }
    }

}
