package br.com.itau.negotiationservice.repository;

import br.com.itau.negotiationservice.dto.ContratoDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ContratoRepository extends ReactiveMongoRepository<ContratoDTO, Integer> {
}
