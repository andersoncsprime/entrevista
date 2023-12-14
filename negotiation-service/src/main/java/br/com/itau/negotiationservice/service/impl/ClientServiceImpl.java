package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.ClientDTO;
import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.repository.ClientRepository;
import br.com.itau.negotiationservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    @Override
    public Mono<ClientDTO> getById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Flux<ClientDTO> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<ClientDTO> saveCient(ClientDTO client) {
        return clientRepository.save(client);
    }


    @Override
    public Mono<Void> delete(String id) {
        return clientRepository.deleteById(id);
    }
}
