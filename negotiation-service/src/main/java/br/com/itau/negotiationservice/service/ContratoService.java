package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.ContratoDTO;
import reactor.core.publisher.Flux;

public interface ContratoService {

    Flux<ContratoDTO> getAll();
}
