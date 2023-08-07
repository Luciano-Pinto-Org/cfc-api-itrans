package br.gov.am.prodam.cfc_api_itrans.model.dto;

import lombok.Builder;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Builder
@Accessors(fluent = true)
public record InstrutorDTO(
        String nome,
        String cpf,
        String logradouro,
        String numCasa,
        String complemento,
        String cep,
        LocalDate dtNascimento
) {

}