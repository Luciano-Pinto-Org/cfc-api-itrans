package br.gov.am.prodam.cfc_api_itrans.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ImagensDTO implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	public ImagensDTO() {}

	private String foto;

}
