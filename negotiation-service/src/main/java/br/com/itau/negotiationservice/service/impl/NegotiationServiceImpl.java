package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.*;
import br.com.itau.negotiationservice.repository.ClientRepository;
import br.com.itau.negotiationservice.repository.ContratoRepository;
import br.com.itau.negotiationservice.repository.DividaRepository;
import br.com.itau.negotiationservice.repository.ProductRepository;
import br.com.itau.negotiationservice.service.NegotiationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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
    public Mono<ContratoDTO> contratar(DividaDTO dividaDTO) {
        return Mono.deferContextual(contextView ->
                dividaRepository.findById(dividaDTO.getId())
                        .flatMap(divida -> productRepository.findById(dividaDTO.getId_product())
                                .flatMap(product -> clientRepository.findById(dividaDTO.getId_client())
                                        .flatMap(client -> clientRepository
                                                .findById(dividaDTO.getId_client())
                                                .map(contract -> gerarContrato(divida, product, client))))));
    }

    public Mono<AcordoDTO> simular(int idDivida, int qtdParcelas) {
        return Mono.deferContextual(contextView -> {
            return dividaRepository.findById(idDivida)
                    .map(dividaDTO -> {
                        double valorFinal = getValoresAtualizados(dividaDTO, qtdParcelas);
                        return AcordoDTO.builder()
                                .dataProposta(LocalDateTime.now())
                                .juros(dividaDTO.getPercentualJuros())
                                .id_divida(dividaDTO.getId()) // Ajustei o nome do método conforme a convenção JavaBeans
                                .qtdParcelas(qtdParcelas)
                                .valorParcela(valorFinal / qtdParcelas)
                                .build();
                    });
        });
    }
    private double getValoresAtualizados(DividaDTO dividaDTO, int qtdParcelas) {
        double valorAtualizado = dividaDTO.getValor();
        double percentual = dividaDTO.getPercentualJuros() / 100.0;
        return valorAtualizado + (percentual * valorAtualizado);
    }

    private ContratoDTO gerarContrato(DividaDTO divida, ProductDTO product, ClientDTO client) {
        return ContratoDTO.builder().productDTO(product).clientDTO(client).dividaDTO(divida).build();
    }

    public Flux<ProductDTO> oferecerProdutos(String idAcordo) {
        return null;
    }

}