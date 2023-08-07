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

@Entity(name = "Entidade")
@Table(name = "MF_RENA_TAB_ENTIDADE", schema = "TRANSITO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Entidade implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EC_CODIGO_ENTIDADE")
	private Long id;

	@Column(name = "EC_CNPJ")
	private String cnpj;

	@Column(name = "EC_TIPO_RESPONSAVEL_CFC")
	private String tipoResponsavelCfc;

	@Column(name = "EC_RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name = "EC_NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name = "EC_NOME_REDUZIDO")
	private String nomeReduzido;
	
	@Column(name = "EC_STATUS_EXCLUIDO")
	private String statusExcluido;
	
	@Column(name = "EC_EMAIL")
	private String email;
	
	@Column(name = "EC_CPF_PROPRIET")
	private String cpfProprietario;
	
	@Column(name = "EC_CPF_PROPRIET_2")
	private String cpfProprietario2;
	
	@Column(name = "EC_CPF_PROPRIET_3")
	private String cpfProprietario3;
	
	@Column(name = "EC_DATA_VALIDADE_ALVARA")
	private Integer dataValidadeAlvara;
	
	@Column(name = "EC_CATEG_ATIVIDADE")
	private String categoriaAtividade;
	
	@Column(name = "EC_CPF_DIRETOR_GERAL")
	private String cpfDiretorGeral;
	
	@Column(name = "EC_CPF_DIRETOR_ENSINO")
	private String cpfDiretorEnsino;
	
	@Column(name = "EC_NUM_PORTARIA_CRED")
	private Integer numeroPortaria;
	
	@Column(name = "EC_ANO_PORTARIA_CRED")
	private Integer anoPortaria;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Entidade entidade = (Entidade) o;
		return getId() != null && Objects.equals(getId(), entidade.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}