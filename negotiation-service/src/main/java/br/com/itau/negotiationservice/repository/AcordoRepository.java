package br.com.itau.negotiationservice.repository;

import br.com.itau.negotiationservice.dto.ClientDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcordoRepository extends ReactiveMongoRepository<ClientDTO, Integer> {
}
