package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/divida")
public class DividaController {
    @Autowired
    private DividaService dividaService;

    @GetMapping("/{id}")
    public Mono<DividaDTO> getById(@PathVariable("id") final String id) {

        return dividaService.getById(id);
    }

    @GetMapping("/list")
    public Flux<DividaDTO> listAll() {
        return dividaService.getAll();
    }

    @PostMapping("save")
    public Mono<DividaDTO> save(@RequestBody DividaDTO dividaDTO) {

        return dividaService.save(dividaDTO);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteVoidMono(@PathVariable("id") final String id) {
        return dividaService.delete(id);
    }
  
}
