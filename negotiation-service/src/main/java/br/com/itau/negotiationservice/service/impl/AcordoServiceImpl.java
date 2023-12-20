package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.repository.AcordoRepository;
import br.com.itau.negotiationservice.service.AcordoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@Transactional
@AllArgsConstructor
public class AcordoServiceImpl implements AcordoService {

    @Autowired
    private AcordoRepository acordoRepository;

    @Override
    public Flux<AcordoDTO> getAll() {
        return acordoRepository.findAll();
    }

}
