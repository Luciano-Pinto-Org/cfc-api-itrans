package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

/**
 * Representa a Situação do Aluno na respectiva Aula Teórica.
 * Transições possíveis:
 * - AULA_AGENDADA -> CHECKIN_REALIZADO -> CHECKOUT_REALIZADO 
 * - AULA_AGENDADA -> FA
 * 
 * @author Bruno
 *
 */

@Getter
@RequiredArgsConstructor
public enum SituacaoAlunoAula {
	
	AULA_AGENDADA("1"),
	CHECKIN_REALIZADO("2"),
	CHECKOUT_REALIZADO("4"),
	REPOSICAO_PENDENTE("7"),
	ALUNO_FALTOSO("8"),
	AULA_CANCELADA("9");
	
	private final String code;

	public static SituacaoAlunoAula parse(String code) {
		if (code == null || code.isEmpty()) {
			return null;
		}
		
		return Stream.of(SituacaoAlunoAula.values())
				.filter(situacaoAlunoAula -> situacaoAlunoAula.code.equals(code))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
    }
	
}
