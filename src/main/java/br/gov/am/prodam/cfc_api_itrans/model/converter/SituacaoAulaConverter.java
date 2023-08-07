package br.gov.am.prodam.cfc_api_itrans.model.converter;


import br.gov.am.prodam.cfc_api_itrans.model.enums.SituacaoAula;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SituacaoAulaConverter implements AttributeConverter<SituacaoAula, String> {

	@Override
	public String convertToDatabaseColumn(SituacaoAula attribute) {
		return attribute.getCode();
	}

	@Override
	public SituacaoAula convertToEntityAttribute(String dbData) {
		return SituacaoAula.parse(dbData);
	}

}
