package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface NegotiationService {

    Mono<AcordoDTO> simular(int idDivida,int qtdParcelas);

    Mono<ContratoDTO> contratar(DividaDTO dividaDTO);
}
