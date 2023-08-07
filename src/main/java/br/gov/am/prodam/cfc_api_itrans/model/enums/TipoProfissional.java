package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TipoProfissional {
	
	DIRETOR_GERAL("01", "Diretor Geral"),
	DIRETOR_ENSINO("02", "Diretor Ensino"),
	EXAMINADOR("03", "Examinador"),
	INSTRUTOR_TRANSITO("04", "Instrutor de Trânsito"),
	INSTRUTOR_TRANSITO_AUTONOMO("05", "Instrutor de Trânsito Autônomo"),
	JUNTA_MEDICA("06", "Junta Médica"),
	JUNTA_PSICOLOGICA("07", "Junta Psicólogo"),
	MEDICO("08", "Médico"),
	PSICOLOGO("09", "Psicólogo"),
	EXAMINADOR_ENTIDADES_ESPECIAIS("10", "Examinador Entidades Especiais");

	private final String code;
	private final String descricao;

	public static TipoProfissional parse(String code) {
		if (code == null || code.isEmpty()) {
			return null;
		}

		return Stream.of(TipoProfissional.values())
				.filter(tipoProfissional -> tipoProfissional.code.equals(code))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}

}
