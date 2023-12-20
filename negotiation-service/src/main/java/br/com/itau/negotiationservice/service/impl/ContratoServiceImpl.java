package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.ContratoDTO;
import br.com.itau.negotiationservice.repository.ContratoRepository;
import br.com.itau.negotiationservice.service.ContratoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@Transactional
@AllArgsConstructor
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Override
    public Flux<ContratoDTO> getAll() {
        return contratoRepository.findAll();
    }
}
