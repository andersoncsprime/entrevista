package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.repository.AcordoRepository;
import br.com.itau.negotiationservice.repository.ClientRepository;
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
    private ClientRepository clientRepository;

    public Flux<DividaDTO> simularPagamento(String idAcordo, Double valorSimulado) {
        // Lógica para simular o pagamento e calcular as dívidas restantes

        return Flux.just(new DividaDTO());
    }

    @Override
    public Mono<ContratoDTO> negociar(DividaDTO dividaDTO) {
        return Mono.deferContextual(contextView -> {
            dividaRepository.findById(dividaDTO.getId())
                    .flatMap(product -> {
                        productRepository.findById(dividaDTO.getId_product())
                                .flatMap(cliente -> clientRepository.findById(dividaDTO.getId_client())
                                        return ContratoDTO.builder()
                            .productDTO().setProductDTO(product)
                            .clientDTO(client)
                    })
        })

    }

    public Flux<ProductDTO> oferecerProdutos(String idAcordo) {
        // Lógica para oferecer produtos com base no acordo
        return null;
    }

}