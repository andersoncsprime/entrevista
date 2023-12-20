package br.com.itau.negotiationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class AcordoDTO {

    private int id;
    private int id_divida;
    private LocalDateTime dataProposta;
    private double valorParcela;
    private double juros;
    private int qtdParcelas;
}
