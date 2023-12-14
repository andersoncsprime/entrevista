package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.ClientDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<ClientDTO> getById(String id);

    Flux<ClientDTO> getAll();

    Mono<ClientDTO> saveCient(ClientDTO client);

    Mono<Void> delete(String id);
}
