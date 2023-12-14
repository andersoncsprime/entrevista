package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.repository.AcordoRepository;
import br.com.itau.negotiationservice.repository.DividaRepository;
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
    private AcordoRepository acordoRepository;
    @Override
    public Mono<AcordoDTO> agruparDividas(int idDividas, double novoValor) {
        return null;
    }

    public Flux<DividaDTO> simularPagamento(String idAcordo, Double valorSimulado) {
        // Lógica para simular o pagamento e calcular as dívidas restantes

        return Flux.just(new DividaDTO());
    }

    public Flux<ProductDTO> oferecerProdutos(String idAcordo) {
        // Lógica para oferecer produtos com base no acordo
        return null;
    }

    public Mono<AcordoDTO> efetivarAcordo(String idAcordo) {
        // Lógica para efetivar o acordo
        return null;
    }
}
