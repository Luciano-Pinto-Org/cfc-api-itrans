package br.gov.am.prodam.cfc_api_itrans.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CFC_SALA_TEORICA", schema = "TRANSITO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class SalaTeorica implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SALA_ID")
	private Long id;

	@Column(name = "SALA_NOME")
	private String nome;

//	@Column(name = "SALA_LOGRADOURO_ENDE")
//	private String logradouro;
//
//	@Column(name = "SALA_NUMERO_ENDE")
//	private String numero;
//
//	@Column(name = "SALA_COMPLEMENTO_ENDE")
//	private String complemento;
//	
//	@Column(name = "SALA_COD_ENTIDADE")
//	private EntidadeEntity entidade;
//	
//	@Column(name = "SALA_COD_MUNIC")
//	private Long municipio;
//	
//	@Column(name = "SALA_COD_BAIRRO")
//	private Long bairro;
//	
//	@Column(name = "SALA_ATIVO")
//	private String ativo;
//	
//	@Column(name = "SALA_DATA_HORA_ATIVACAO")
//	private Date dataHoraAtivacao;
//	
//	@Column(name = "SALA_DATA_HORA_INATIVACAO")
//	private Date dataHoraInativacao;
//	
//	@Column(name = "SALA_CPF_USUARIO")
//	private String cpfUsuario;
//	
//	@Column(name = "SALA_NOME_USUARIO")
//	private String nomeUsuario;
//	
//	@Column(name = "SALA_DATA_HORA_USUARIO")
//	private Date dataHoraUsuario;
	
	@Column(name = "SALA_LIMITE_VAGAS")
	private Integer limiteVagas;
	
	@Column(name = "SALA_LIMITE_REPOSICAO")
	private Integer limiteReposicao;
	
	@Column(name = "SALA_FL_VIRTUAL")
	private String virtual;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		SalaTeorica that = (SalaTeorica) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}