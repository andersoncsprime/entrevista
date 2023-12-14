package br.com.itau.negotiationservice.repository;

import br.com.itau.negotiationservice.dto.ProductDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductDTO, String> {

}
