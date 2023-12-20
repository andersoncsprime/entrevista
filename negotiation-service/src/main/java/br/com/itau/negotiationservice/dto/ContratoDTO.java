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
public class ContratoDTO {
    @Id
    private Integer id;
    private ClientDTO clientDTO;
    private ProductDTO productDTO;
    private DividaDTO dividaDTO;
    private AcordoDTO acordoDTO;
    private NegotiationDTO negotiationDTO;
}
