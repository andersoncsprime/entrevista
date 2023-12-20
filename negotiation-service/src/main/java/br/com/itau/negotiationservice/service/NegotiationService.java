package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import reactor.core.publisher.Mono;

public interface NegotiationService {

    Mono<ContratoDTO> negociar(DividaDTO dividaDTO);
}
