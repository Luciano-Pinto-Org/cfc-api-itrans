package br.gov.am.prodam.cfc_api_itrans.model;


import br.gov.am.prodam.cfc_api_itrans.model.converter.SituacaoAlunoAulaConverter;
import br.gov.am.prodam.cfc_api_itrans.model.enums.SituacaoAlunoAula;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "AlunoAulaTeorica")
@Table(name = "CFC_ALUNO_AULA_TEORICA", schema = "TRANSITO")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class AlunoAulaTeorica implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "AAT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALUNO_AULATEORICA_SEQUENCE_GENERATOR")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "AAT_RENA_SERVICO_ID", nullable=false)
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "AAT_AT_ID")
	private AulaTeorica aulaTeorica;
	
	@ManyToOne
	@JoinColumn(name = "AAT_TURMA_ID")
	private TurmaTeorica turmaTeorica;
	
	@ManyToOne
	@JoinColumn(name = "AAT_ALU_TUR_ID")
	private AlunoTurma alunoTurma;
	
	@Column(name = "AAT_DATA_HORA_CHECKIN")
	private LocalDateTime dataHoraCheckin;
		
	@Column(name = "AAT_DATA_HORA_CHECKOUT")
	private LocalDateTime dataHoraCheckout;
	
	@Column (name = "AAT_SITUACAO")
	@Convert(converter = SituacaoAlunoAulaConverter.class)
	private SituacaoAlunoAula situacao;
	
	@Column(name = "AAT_QTD_HORAS")
	private Integer qtdeHoras;
	
	@Column(name = "AAT_TIPO_CHECKIN")
	private Integer tipoCheckin;
	
	@Column(name = "AAT_TIPO_CHECKOUT")
	private Integer tipoCheckout;
	
	@Column(name = "AAT_CPF_USER_CHECKIN")
	private String cpfUserCheckin;
	
	@Column(name = "AAT_CPF_USER_CHECKOUT")
	private String cpfUserCheckout;
	
	@Column(name = "AAT_DATA_CANCELOU")

	private LocalDate dataCancelou;
	
	@Column(name = "AAT_MOTIVO_CANCELOU")
	private String motivoCancelou;

	@Column(name = "AAT_AULA_REPOSICAO")
	private String reposicao;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		AlunoAulaTeorica that = (AlunoAulaTeorica) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}