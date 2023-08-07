package br.gov.am.prodam.cfc_api_itrans.model;


import br.gov.am.prodam.cfc_api_itrans.model.converter.SituacaoAulaConverter;
import br.gov.am.prodam.cfc_api_itrans.model.enums.SituacaoAula;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "AulaTeorica")
@Table(name = "CFC_AULA_TEORICA", schema = "TRANSITO")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class AulaTeorica implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "AT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AULATEORICA_SEQUENCE_GENERATOR")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "AT_TURMA_ID")
	private TurmaTeorica turma;

	@Formula("TRUNC(at_data_hora_inicial)")
	private LocalDate dataAula;
	
	@Column(name = "AT_DATA_HORA_INICIAL")
	private LocalTime dataHoraInicial;

	@Column(name = "AT_DATA_HORA_FINAL")
	private LocalTime dataHoraFinal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AT_CPF_INSTRUTOR")
	@ToString.Exclude
	private Profissional instrutor;
	
	@Column(name = "AT_DATA_HORA_ABERTURA")
	private LocalDateTime dataHoraAbertura;
	
	@Column(name = "AT_DATA_HORA_FECHAMENTO")
	private LocalDateTime dataHoraFechamento;
	
	@Column(name = "AT_SITUACAO")
	@Convert(converter = SituacaoAulaConverter.class)
	private SituacaoAula situacao;
	
	@Column(name = "AT_MOTIVO_ALTERACAO")
	private String motivoAlteracao;
	
	@Column(name = "AT_QTD_HORAS_CONSIDERADAS")
	private Integer horasConsideradas;
	
	@Column(name = "AT_DATA_ATUALIZACAO")
	private LocalTime dataHoraAtualizacao;
	
	@Column(name = "AT_USUARIO_ATUALIZACAO")
	private Long usuarioAtualizacao;
	
	@Column(name = "AT_DIA")
	private Integer dia;
	
	@Column(name = "AT_FL_VIRTUAL")
	private String virtual;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CFC_AULA_TEORICA_DISCIPLINA", schema = "TRANSITO", joinColumns = {
			@JoinColumn(name = "ID_CFC_AULA_TEORICA", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "ID_CFC_DISCIPLINA", nullable = false, updatable = false) })
	@ToString.Exclude
	private List<Disciplina> disciplinas;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		AulaTeorica that = (AulaTeorica) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}