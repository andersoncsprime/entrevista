package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NegotiationService {

    Mono<AcordoDTO> agruparDividas(int idDividas, double novoValor);

    Mono<AcordoDTO> efetivarAcordo(String idAcordo);

    Flux<ProductDTO> oferecerProdutos(String idAcordo);

    Flux<DividaDTO> simularPagamento(String idAcordo, Double valorSimulado);
}
