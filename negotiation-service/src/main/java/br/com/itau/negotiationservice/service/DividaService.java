package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.ClientDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DividaService {

    Mono<DividaDTO> getById(Integer id);

    Flux<DividaDTO> getAll();

    Mono<DividaDTO> save(DividaDTO dividaDTO);

    Mono<Void> delete(Integer id);
}
