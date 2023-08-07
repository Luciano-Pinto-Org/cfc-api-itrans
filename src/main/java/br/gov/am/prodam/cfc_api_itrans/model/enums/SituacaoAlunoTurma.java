package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum SituacaoAlunoTurma {
	
	AGENDADO("1"),
	CONCLUIDO("3"),
	REPOSICAO_REALIZADA("4"),
	PENDENTE("7"),
	FALTOSO("8"),
	CANCELADO("9");
		
	private final String code;
	
	public static SituacaoAlunoTurma parse(String code) {
		if (code == null || code.isEmpty()) {
			return null;
		}
		
		return Stream.of(SituacaoAlunoTurma.values())
				.filter(situacaoAlunoTurma -> situacaoAlunoTurma.code.equals(code))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
    }

}
