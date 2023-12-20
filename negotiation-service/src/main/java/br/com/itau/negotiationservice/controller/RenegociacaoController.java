package br.com.itau.negotiationservice.controller;

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

    @PutMapping("/negociar")
    public Mono<ContratoDTO> negociar(@RequestBody DividaDTO dividaDTO) {
        return negotiationService.negociar(dividaDTO);
    }

//    @PostMapping("/{cpf}")
//    public Mono<String> renegociarContrato(@PathVariable String cpf, @RequestBody ContratoDTO novoContrato) {
//        return contratoRepository.findByCPF(cpf)
//                .flatMap(contratoExistente -> {
//                    contratoExistente.setValor(novoContrato.getValor());
//                    contratoExistente.setRenegociado(true);
//                    return contratoRepository.save(contratoExistente).thenReturn("Contrato renegociado com sucesso.");
//                })
//                .switchIfEmpty(Mono.just("Contrato não encontrado."));
//    }
}
