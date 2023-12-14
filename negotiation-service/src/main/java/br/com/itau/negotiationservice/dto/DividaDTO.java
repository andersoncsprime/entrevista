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
public class DividaDTO {

    @Id
    private Integer id;
    private Integer id_product;
    private Integer id_client;
    private double valor;

}
