package br.gov.am.prodam.cfc_api_itrans.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "Individuo")
@Table(name = "MF_RENA_INDIVIDUO", schema = "TRANSITO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Individuo implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IND_NUM_INDIVIDUO")
	private Long id;

	@Column(name = "IND_NOME", length = 44)
	private String nome;

	@Column(name = "IND_NOME_MAE", length = 44)
	private String nomeMae;

	@Column(name = "IND_NOME_PAI", length = 44)
	private String nomePai;

	@Column(name = "IND_CPF", length = 11, unique = true)
	private String cpf;

	@Column(name = "IND_NUM_REGISTRO_RENACH", length = 11, unique = true)
	private String numRegistroRenac;

	@Column(name = "IND_LOGRADOURO_ENDE", length = 80)
	private String logradouro;

	@Column(name = "IND_NUM_CASA_ENDE", length = 10)
	private String numCasa;

	@Column(name = "IND_COMPLEMENTO_ENDE", length = 40)
	private String complemento;

	@Column(name = "IND_CEP_ENDE", length = 8)
	private String cep;

	@Column(name = "IND_CATEG_CARRO_ATUAL", length = 1)
	private String categoriaCarroAtual;

	@Column(name = "IND_CATEG_MOTO_ATUAL", length = 2)
	private String categoriaMotoAtual;

	@Column(name = "IND_CATEG_CARRO_REBAIXADA", length = 1)
	private String categoriaCarroRebaixada;

	@Column(name = "IND_CATEG_MOTO_REBAIXADA", length = 2)
	private String categoriaMotoRebaixada;

	@Column(name = "IND_TELEFONE", length = 12)
	private String telefone;

	@Column(name = "IND_TELEFONE2", length = 12)
	private String telefone2;

	@Column(name = "IND_SEXO", length = 1)
	private String sexo;

	@Column(name = "IND_UF_CNH", length = 2)
	private String ufCNH;

	@Column(name = "IND_DATA_VALIDADE_CNH")
	private LocalDate dtValidadeCNH;

	@Temporal(TemporalType.DATE)
	@Column(name = "IND_DATA_ATUALIZACAO")
	private LocalDate dtAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "IND_DATA_NASCTO")
	private LocalDate dtNascimento;

	@Column(name = "IND_COD_MUNIC_ENDE")
	private Long municipio;

	@Column(name = "IND_UF_REG_ATUAL", length = 2)
	private String ufRGAtual;

	@Column(name = "IND_EMAIL")
	private String email;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Individuo individuo = (Individuo) o;
		return getId() != null && Objects.equals(getId(), individuo.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}