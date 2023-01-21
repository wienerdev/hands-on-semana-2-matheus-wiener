package br.com.eldorado.handsonsemana2matheuswiener.controller;

import br.com.eldorado.handsonsemana2matheuswiener.dto.ImcClienteDto;
import br.com.eldorado.handsonsemana2matheuswiener.dto.ImcClienteResponseDto;
import br.com.eldorado.handsonsemana2matheuswiener.service.ImcClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/imc")
@Slf4j
public class ImcClienteController {

    @Autowired
    private ImcClienteService service;

    @PostMapping
    public ResponseEntity<ImcClienteDto> saveImc(@RequestBody ImcClienteDto dto) {
        return new ResponseEntity<>(service.saveImcCliente(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ImcClienteDto>> getAllImc() {
        return new ResponseEntity<>(service.getAllImc(), HttpStatus.OK);
    }

    @GetMapping("/{idImc}")
    public ResponseEntity<ImcClienteDto> getImcByIdImc(@PathVariable UUID idImc) {
        return new ResponseEntity<>(service.getImcById(idImc), HttpStatus.OK);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<ImcClienteResponseDto> getImcByIdCliente(@PathVariable UUID idCliente) {
        return new ResponseEntity<>(service.getAllImcByIdCliente(idCliente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImcById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
