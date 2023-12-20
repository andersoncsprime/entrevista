package br.com.itau.negotiationservice.service.impl;

import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.repository.ProductRepository;
import br.com.itau.negotiationservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Mono<ProductDTO> getById(String id) {
        return productRepository.findById(id);
    }
    @Override
    public Flux<ProductDTO> getAll() {
        return productRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<ProductDTO> save(ProductDTO product) {
        log.info("Save product: {}, {}", product.getDescriptorProduct(), product.getSegment());
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> delete(String id) {
        return productRepository.deleteById(id);
    }
}
