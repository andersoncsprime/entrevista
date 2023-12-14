package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductDTO> getById(Integer id);

    Flux<ProductDTO> getAll() ;

    Mono<ProductDTO> save(ProductDTO product);

    Mono<Void> delete(Integer id);
}
