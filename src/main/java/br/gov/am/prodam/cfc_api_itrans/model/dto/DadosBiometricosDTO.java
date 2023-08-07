package br.gov.am.prodam.cfc_api_itrans.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DadosBiometricosDTO implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private ImagensDTO imagens;
	
	public Boolean possuiFoto() {
		return imagens != null && imagens.getFoto() != null && !imagens.getFoto().isEmpty();
	}
	
	public String obterFotoBase64() {
		if (!possuiFoto()) {
			return "https://";
		}
		
		return "data:image/png;base64, " + imagens.getFoto();
	}

}
