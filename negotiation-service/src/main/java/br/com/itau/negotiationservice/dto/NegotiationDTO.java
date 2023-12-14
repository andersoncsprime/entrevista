package br.com.itau.negotiationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class NegotiationDTO {

    @Id
    private Integer id;
    private String id_client;
    private String id_product;
    private double valor;
}
