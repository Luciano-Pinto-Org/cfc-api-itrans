package br.gov.am.prodam.cfc_api_itrans.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAulaAutenticacao {
	
	BIOMETRIA(1),
	MANUAL(2),
	FACIAL(3);
	
	private final int id;
	public static TipoAulaAutenticacao parse(int id) {
        TipoAulaAutenticacao situacaoAula = null; // Default
        for (TipoAulaAutenticacao item : TipoAulaAutenticacao.values()) {
            if (item.getId()==id) {
                situacaoAula = item;
                break;
            }
        }
        return situacaoAula;
    }
	
}
