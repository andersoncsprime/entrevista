package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.ClientDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Mono<ClientDTO> getById(@PathVariable("id") final String id) {

        return clientService.getById(id);
    }

    @GetMapping("/list")
    public Flux<ClientDTO> listAll() {
        return clientService.getAll();
    }

    @PostMapping("save")
    public Mono<ClientDTO> saveProduct(@RequestBody ClientDTO client) {
        return clientService.save(client);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteVoidMono(@PathVariable("id") final String id) {
        return clientService.delete(id);
    }
}
