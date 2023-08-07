package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TipoAulaPresenca {
	
	CHECKIN("CHECKIN"),
	CHECKOUT("CHECKOUT"),
	ABERTURA("ABERTURA"),
	FECHAMENTO("FECHAMENTO");
		

	private final String value;

	public static TipoAulaPresenca parse(String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}

		return Stream.of(TipoAulaPresenca.values())
				.filter(tipoAulaPresenca -> tipoAulaPresenca.value.equals(value))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}

}
