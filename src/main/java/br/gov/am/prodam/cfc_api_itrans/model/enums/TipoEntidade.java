package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TipoEntidade {
	
	/**
	 * 01 - Teórico
	 */
	CFC_TEORICO("01", "CFC TEÓRICO"),
	/**
	 * 02 - Prático
	 */
	CFC_PRATICO("02", "CFC PRÁTICO"),
	/**
	 * 08 - Forças Armadas (Ens. Teórico) 
	 */
	FORCAS_ARMADAS_ENSINO_TEORICO("08", "FORÇAS ARMADAS (ENSINO TEÓRICO) "),
	/**
	 * 10 - Forças Auxiliares (Ens. Teórico) 
	 */
	FORCAS_AUXILIARES_TEORICO("10", "FORÇAS AUXILIARES (TEÓRICO)"),
	/**
	 * 12 - Detran (Teórico)
	 */
	DETRAN_ENSINO_TEORICO("12", "DETRAN (ENSINO TEÓRICO)"),
	/**
	 * 14 - Detran Exames (Ensino Teórico)
	 */
	DETRAN_EXAMES("14", "DETRAN EXAMES"),
	/**
	 * 18 - Entidades Especiais (Ensino Teórico)
	 */
	ENTIDADES_ESPECIAIS_TEORICO("18", "ENTIDADES ESPECIAIS (TEÓRICO) "),
	/**
	 * 20 - Entidades Especiais
	 */
	ENTIDADES_ESPECIAIS("20", "ENTIDADES ESPECIAIS"),
	/**
	 * 21 - CFC Teórico Prático
	 */
	CFC_TEORICO_PRATICO("21", "CFC TEÓRICO E PRÁTICO");
	
	private final String code;
	private final String descricao;

	public static TipoEntidade parse(String code) {
		if (code == null || code.isEmpty()) {
			return null;
		}

		return Stream.of(TipoEntidade.values())
				.filter(tipoEntidade -> tipoEntidade.code.equals(code))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
	

}
