package br.com.itau.negotiationservice.service;

import br.com.itau.negotiationservice.dto.AcordoDTO;
import br.com.itau.negotiationservice.dto.ClientDTO;
import reactor.core.publisher.Flux;

public interface AcordoService {

    Flux<AcordoDTO> getAll();
}
