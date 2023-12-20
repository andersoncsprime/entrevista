package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.ClientDTO;
import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.repository.ClientRepository;
import br.com.itau.negotiationservice.repository.ContratoRepository;
import br.com.itau.negotiationservice.repository.DividaRepository;
import br.com.itau.negotiationservice.repository.ProductRepository;
import br.com.itau.negotiationservice.service.NegotiationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class NegotiationServiceImpl implements NegotiationService {


    @Autowired
    private DividaRepository dividaRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Flux<DividaDTO> simularPagamento(String idAcordo, Double valorSimulado) {

        return null;
    }

    @Override
    public Mono<ContratoDTO> negociar(DividaDTO dividaDTO) {
        return Mono.deferContextual(contextView ->
                dividaRepository.findById(dividaDTO.getId())
                        .flatMap(divida -> productRepository.findById(dividaDTO.getId_product())
                                .flatMap(product -> clientRepository.findById(dividaDTO.getId_client())
                                        .flatMap(client -> clientRepository
                                                .findById(dividaDTO.getId_client())
                .map(contract -> gerarContrato(divida, product, client))))));
    }

    private ContratoDTO gerarContrato(DividaDTO divida, ProductDTO product, ClientDTO client) {
        return ContratoDTO.builder().productDTO(product).clientDTO(client).dividaDTO(divida).build();
    }

    public Flux<ProductDTO> oferecerProdutos(String idAcordo) {
        return null;
    }

}