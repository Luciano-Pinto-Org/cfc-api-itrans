package br.gov.am.prodam.cfc_api_itrans.model;


import br.gov.am.prodam.cfc_api_itrans.model.converter.SituacaoAlunoTurmaConverter;
import br.gov.am.prodam.cfc_api_itrans.model.enums.SituacaoAlunoTurma;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "AlunoTurma")
@Table(name = "CFC_ALUNO_TURMA", schema = "TRANSITO")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class AlunoTurma implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "CFC_ALUNO_TURMA_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
	@Column(name = "ALU_TUR_ID")
	private Long id;

	/*@ManyToOne
	@JoinColumn(name = "ALU_TUR_TURMAS_ID")
	private TurmaTeorica turma;*/

	@Column(name = "ALU_TUR_TURMAS_ID")
	private Long turmaTeoricaId;

	@ManyToOne
	@JoinColumn(name = "ALU_TUR_RENA_SERVICO_ID")
	private Servico servico;

	@Column(name = "ALU_TUR_USUARIO_ALTERACAO")
	private Long usuarioAlteracao;

	@Column(name = "ALU_TUR_DATA_ALTERACAO")
	private LocalDate dataAlteracao;

	@Column(name = "ALU_TUR_SITUACAO")
	@Convert(converter = SituacaoAlunoTurmaConverter.class)
	private SituacaoAlunoTurma situacao;

	@Column(name = "ALU_TUR_REPOSICAO")
	private String reposicao;

	@Column(name = "ALU_TUR_FL_VIRTUAL")
	private String isVirtual;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		AlunoTurma that = (AlunoTurma) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}