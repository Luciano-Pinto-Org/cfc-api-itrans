package br.gov.am.prodam.cfc_api_itrans.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "Credenciamento")
@Table(name = "MF_RENA_CREDENCIAMENTOS", schema = "TRANSITO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Credenciamento implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CRED_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CRED_COD_ENTIDADE")
	private Entidade entidade;
	
	@ManyToOne
	@JoinColumn(name ="CRED_CPF_PROFISSIONAL")
	private Profissional profissional;
	
	@Column(name = "CRED_TIPO_PROFISSIONAL")
	private String tipoProfissional;
	
	@Column(name = "CRED_TIPO_ENTIDADE")
	private String tipoEntidade;
	
	@Column(name = "CRED_DATA_INICIO")
	private LocalDate dataInicio;
	
	@Column(name = "CRED_DATA_FIM")
	private LocalDate dataFim;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Credenciamento that = (Credenciamento) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
