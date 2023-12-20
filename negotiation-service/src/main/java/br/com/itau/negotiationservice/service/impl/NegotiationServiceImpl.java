package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.*;
import br.com.itau.negotiationservice.repository.*;
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
    @Autowired
    private AcordoRepository acordoRepository;

    public Flux<DividaDTO> simularPagamento(String idAcordo, Double valorSimulado) {

        return null;
    }

    @Override
    public Mono<ContratoDTO> contratar(String idAcordo) {
        return Mono.deferContextual(contextView ->
                acordoRepository.findById(idAcordo)
                        .flatMap(acordo -> dividaRepository.findById(acordo.getId_divida())
                                .flatMap(divida -> productRepository.findById(divida.getId_product())
                                        .flatMap(product -> clientRepository.findById(divida.getId_client())
                                                .flatMap(client -> {
                                                    return contratoRepository.save(
                                                            gerarContrato(divida, product, client, acordo)
                                                    );
                                                })
                                        )
                                )
                        )
        );
    }

    public Mono<AcordoDTO> simular(String idDivida, int qtdParcelas) {
        return dividaRepository.findById(idDivida)
                .flatMap(dividaDTO -> {
                    double valorFinal = getValoresAtualizados(dividaDTO, qtdParcelas);

                    return acordoRepository.save(AcordoDTO.builder()
                            .dataProposta(LocalDateTime.now())
                            .juros(dividaDTO.getPercentualJuros())
                            .id_divida(dividaDTO.getId())
                            .qtdParcelas(qtdParcelas)
                            .valorParcela(valorFinal / qtdParcelas)
                            .build());
                });
    }

    private double getValoresAtualizados(DividaDTO dividaDTO, int qtdParcelas) {
        double valorAtualizado = dividaDTO.getValor();
        double percentual = dividaDTO.getPercentualJuros() / 100.0;
        return valorAtualizado + (percentual * valorAtualizado);
    }

    private ContratoDTO gerarContrato(DividaDTO divida, ProductDTO product, ClientDTO client, AcordoDTO acordoDTO) {
        return ContratoDTO.builder().productDTO(product).clientDTO(client).dividaDTO(divida).acordoDTO(acordoDTO).build();
    }

    public Flux<ProductDTO> oferecerProdutos(String idAcordo) {
        return null;
    }

}