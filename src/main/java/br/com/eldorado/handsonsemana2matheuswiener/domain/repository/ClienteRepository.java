package br.com.eldorado.handsonsemana2matheuswiener.domain.repository;

import br.com.eldorado.handsonsemana2matheuswiener.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, UUID> {
}
