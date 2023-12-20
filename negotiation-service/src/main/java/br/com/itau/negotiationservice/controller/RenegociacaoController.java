package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.*;
import br.com.itau.negotiationservice.repository.ContratoRepository;
import br.com.itau.negotiationservice.service.NegotiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/renegociacao")
public class RenegociacaoController {

    @Autowired
   private NegotiationService negotiationService;

    @PutMapping("/contratar")
    public Mono<ContratoDTO> negociar(@RequestParam(value = "idAcordo") String idAcordo) {
        return negotiationService.contratar(idAcordo);
    }

    @PutMapping("/simular")
    public Mono<AcordoDTO> simular(@RequestParam(value = "qtdParcelas") int qtdParcelas,
    @RequestParam(value = "idDivida") String idDivida) {
        return negotiationService.simular(idDivida, qtdParcelas);
    }

}
