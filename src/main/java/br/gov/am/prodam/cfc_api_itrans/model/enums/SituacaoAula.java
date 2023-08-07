package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum SituacaoAula {
	
	AGENDADA("0"),
	ABERTA("1"),
	FECHADA("3"),
	CANCELADA("9");
		
	private String code;
	
	public static SituacaoAula parse(String code) {
		if (code == null || code.isEmpty()) {
			return null;
		}
		
		return Stream.of(SituacaoAula.values())
				.filter(situacaoAula -> situacaoAula.code.equals(code))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
    }
	
}
