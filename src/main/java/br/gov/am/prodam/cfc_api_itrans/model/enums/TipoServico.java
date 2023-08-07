package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TipoServico {


	PRIMEIRA_VIA_CNH("C01", "1A. VIA DE CNH"),

	SEGUNDA_VIA_CNH("C02", "2A. VIA DE CNH"),

	RENOVACAO_CNH("C03", "RENOVACAO DE CNH"),

	TROCA_CATEGORIA("C04", "TROCA DE CATEGORIA"),

	LIBERACAO_CNH_APREENDIDA("C17", "LIBERACAO CNH APREENDIDA"),

	TROCA_CART_ESTR_PARA_CNH("C19", "TROCA CART. ESTRANG. P/ CNH"),

	REABILITACAO_CONDUTOR("C32", "REABILITACAO DE CONDUTOR"),

	CURSO_ESPECIALIZACAO("C35", "CURSO ESPECILIZACAO");

	private final String code;
	private final String descricao;

	public static TipoServico parse(String code) {
		if (code == null || code.isEmpty()) {
			return null;
		}

		return Stream.of(TipoServico.values())
				.filter(tipoServico -> tipoServico.code.equals(code))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
	

}
