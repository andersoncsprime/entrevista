package br.com.itau.negotiationservice.repository;

import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividaRepository extends ReactiveMongoRepository<DividaDTO, Integer> {
}
