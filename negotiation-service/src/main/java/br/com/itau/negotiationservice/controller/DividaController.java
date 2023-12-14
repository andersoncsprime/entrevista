package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.NegociacaoRequest;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.service.NegotiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/divida")
public class DividaController {


    @Autowired
    private NegotiationService negociacaoService;

    @PostMapping("/agrupar")
    public Mono<AcordoDTO> agruparDividas(@RequestBody NegociacaoRequest request) {
        return negociacaoService.agruparDividas(request.getIdDividas(), request.getNovoValor());
    }

    @PostMapping("/simular-pagamento/{idAcordo}")
    public Flux<DividaDTO> simularPagamento(@PathVariable String idAcordo, @RequestParam Double valorSimulado) {
        return negociacaoService.simularPagamento(idAcordo, valorSimulado);
    }

    @GetMapping("/oferecer-produtos/{idAcordo}")
    public Flux<ProductDTO> oferecerProdutos(@PathVariable String idAcordo) {
        return negociacaoService.oferecerProdutos(idAcordo);
    }

    @PostMapping("/efetivar-acordo/{idAcordo}")
    public Mono<AcordoDTO> efetivarAcordo(@PathVariable String idAcordo) {
        return negociacaoService.efetivarAcordo(idAcordo);
    }
}
