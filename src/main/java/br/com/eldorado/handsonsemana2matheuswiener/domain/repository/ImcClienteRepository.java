package br.com.eldorado.handsonsemana2matheuswiener.domain.repository;

import br.com.eldorado.handsonsemana2matheuswiener.domain.model.ImcCliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImcClienteRepository extends MongoRepository<ImcCliente, UUID> {

    List<ImcCliente> findByIdCliente(UUID idCliente);
}
