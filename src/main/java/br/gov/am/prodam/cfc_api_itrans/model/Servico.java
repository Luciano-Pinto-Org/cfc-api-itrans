package br.gov.am.prodam.cfc_api_itrans.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "Servico")
@Table(name = "MF_RENA_SERVICO", schema = "TRANSITO")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Servico implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_MF_RENA_SERVICO")
	private Long id;

	@Column(name = "SS_DATA_NUM_PROTOCOLO")
	private Long dataNumProtocolo;

	@ManyToOne
	@JoinColumn(name = "ID_MF_RENA_INDIVIDUO")
	private Individuo individuo;

	@Column(name = "SS_COD_SERVICO")
	private String codServico;

	@Column(name = "SS_COD_CATEGORIA", length = 4)
	private String categoria;

	@Column(name = "SS_NUM_FORM_RENACH")
	private String numFormRenach;

	@Column(name = "SS_INDIC_ATIV_REMUNERADA", length = 1)
	private Character atividadeRemunerada;

	@Column(name = "SS_DATA_EXEC_SERV")
	private LocalDate dataExecucaoServico;

	@Column(name = "SS_CAPTURA_REALIZADA", length = 1)
	private Character capturaRealizada;

	@Column(name = "SS_COD_CATEG_2RODAS", length = 2)
	private String codCateg2Rodas;

	@Column(name = "SS_COD_CATEG_4RODAS", length = 2)
	private String codCateg4Rodas;
	
	@Column(name = "SS_DATA_INICIO_PROCESSO")
	private LocalDate dataInicioProcesso;
	
	@Column(name = "SS_DATA_VALIDADE_PROCESSO")
	private LocalDate dataValidadeProcesso;

	@Column(name = "SS_DATA_CANCELAMENTO")
	private LocalDate dataCancelamento;

	@Column(name = "SS_DATA_PAGAMENTO")
	private LocalDate dataPagamento;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Servico that = (Servico) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}