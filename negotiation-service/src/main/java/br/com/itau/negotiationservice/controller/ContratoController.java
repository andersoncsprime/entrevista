package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.service.AcordoService;
import br.com.itau.negotiationservice.service.ContratoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/contrato")
@Slf4j
@RequiredArgsConstructor
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping("/list")
    public Flux<ContratoDTO> listAll() {
        return contratoService.getAll();
    }
}
