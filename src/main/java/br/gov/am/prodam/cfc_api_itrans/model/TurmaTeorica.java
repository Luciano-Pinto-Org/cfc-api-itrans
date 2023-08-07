package br.gov.am.prodam.cfc_api_itrans.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "TurmaTeorica")
@Table(name = "CFC_TURMA_TEORICA", schema = "TRANSITO")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class TurmaTeorica implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TURMA_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_MF_RENA_TAB_ENTIDADE")
	private Entidade entidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CFC_SALA_TEORICA")
	@ToString.Exclude
	private SalaTeorica sala;

	@Column(name = "TURMA_DATA_INICIO")
	private LocalDate dataHoraInicial;

	@Column(name = "TURMA_DATA_FIM")
	private LocalDate dataHoraFinal;
	
	@Column(name = "TURMA_QTD_VAGAS")
	private Integer vagas;
	
	@Column(name = "TURMA_NUM_PARTICIPANTES")
	private Integer participantes;
	
	@Column(name = "TURMA_SITUACAO")
	private String situacao;
	
	@Column(name = "TURMA_MOTIVO_ALT")
	private String motivoAlteracao;
	
	@Column(name = "ID_CFC_CURSO")
	private Long curso;
	
	@Column(name = "TURMA_HORA_INICIAL")
	private LocalDate horaInicial;
	
	@Column(name = "TURMA_HORA_FINAL")
	private LocalDate horaFinal;
	
	@Column(name = "TURMA_FL_VIRTUAL")
	private String virtual;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		TurmaTeorica that = (TurmaTeorica) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}