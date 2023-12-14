package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NegotiationService {

    Mono<ContratoDTO> negociar(DividaDTO dividaDTO);
}
