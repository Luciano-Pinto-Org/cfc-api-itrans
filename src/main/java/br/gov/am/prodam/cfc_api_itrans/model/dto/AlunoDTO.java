package br.gov.am.prodam.cfc_api_itrans.model.dto;

import lombok.Builder;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Builder
@Accessors(fluent = true)
public record AlunoDTO(
        String nome,
        String cpf,
        String renach,
        String logradouro,
        String numeroResid,
        String complemento,
        String cep,
        LocalDate dataNascimento,
        LocalDate dataAberturaRenach
) {
}