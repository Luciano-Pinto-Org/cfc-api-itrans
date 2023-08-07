package br.gov.am.prodam.cfc_api_itrans.model.converter;

import br.gov.am.prodam.cfc_api_itrans.model.enums.SituacaoAlunoAula;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SituacaoAlunoAulaConverter implements AttributeConverter<SituacaoAlunoAula, String> {

	@Override
	public String convertToDatabaseColumn(SituacaoAlunoAula attribute) {
		return attribute.getCode();
	}

	@Override
	public SituacaoAlunoAula convertToEntityAttribute(String dbData) {
		return SituacaoAlunoAula.parse(dbData);
	}

}
