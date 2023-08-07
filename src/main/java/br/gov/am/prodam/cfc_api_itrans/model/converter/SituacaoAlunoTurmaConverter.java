package br.gov.am.prodam.cfc_api_itrans.model.converter;


import br.gov.am.prodam.cfc_api_itrans.model.enums.SituacaoAlunoTurma;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SituacaoAlunoTurmaConverter implements AttributeConverter<SituacaoAlunoTurma, String> {

	@Override
	public String convertToDatabaseColumn(SituacaoAlunoTurma attribute) {
		return attribute.getCode();
	}

	@Override
	public SituacaoAlunoTurma convertToEntityAttribute(String dbData) {
		return SituacaoAlunoTurma.parse(dbData);
	}

}
