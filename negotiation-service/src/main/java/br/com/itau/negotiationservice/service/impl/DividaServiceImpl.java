package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.ClientDTO;
import br.com.itau.negotiationservice.dto.DividaDTO;
import br.com.itau.negotiationservice.repository.DividaRepository;
import br.com.itau.negotiationservice.service.DividaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@Transactional
@AllArgsConstructor
public class DividaServiceImpl implements DividaService {

    private DividaRepository dividaRepository;
    @Override
    public Mono<DividaDTO> getById(String id) {
        return dividaRepository.findById(id);
    }

    @Override
    public Flux<DividaDTO> getAll() {
        return dividaRepository.findAll();
    }

    @Override
    public Mono<DividaDTO> save(DividaDTO dividaDTO) {
        return dividaRepository.save(dividaDTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        return dividaRepository.deleteById(id);
    }
}
