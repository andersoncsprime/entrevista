package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.repository.ContratoRepository;
import br.com.itau.negotiationservice.service.NegotiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/renegociacao")
public class RenegociacaoController {

    @Autowired
   private NegotiationService negotiationService;

    @PutMapping("/contratar")
    public Mono<ContratoDTO> negociar(@RequestBody DividaDTO dividaDTO) {
        return negotiationService.contratar(dividaDTO);
    }

    @PutMapping("/simular")
    public Mono<AcordoDTO> simular(@RequestParam(value = "qtdParcelas") int qtdParcelas,
    @RequestParam(value = "idDivida") int idDivida) {
        return negotiationService.simular(idDivida, qtdParcelas);
    }


}
