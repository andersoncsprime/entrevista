package br.com.itau.negotiationservice.controller;

import br.com.itau.negotiationservice.dto.ProductDTO;
import br.com.itau.negotiationservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Mono<ProductDTO> getById(@PathVariable("id") final String id) {
        return productService.getById(id);
    }

    @GetMapping("/list")
    public Flux<ProductDTO> listAll() {
        return productService.getAll();
    }

    @PostMapping("save")
    public Mono<ProductDTO> saveProduct(@RequestBody ProductDTO product) {

        return productService.save(product);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> saveProduct(@PathVariable("id") final String id) {

        return productService.delete(id);
    }


}
