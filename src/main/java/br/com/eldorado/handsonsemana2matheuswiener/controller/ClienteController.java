package br.com.eldorado.handsonsemana2matheuswiener.controller;

import br.com.eldorado.handsonsemana2matheuswiener.dto.ClienteDto;
import br.com.eldorado.handsonsemana2matheuswiener.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDto> saveCliente(@RequestBody ClienteDto dto) {
        return new ResponseEntity<>(service.saveCliente(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        return new ResponseEntity<>(service.getAllClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getClienteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable UUID id, @RequestBody ClienteDto dto) {
        return new ResponseEntity<>(service.updateCliente(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClienteById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
