package br.gov.am.prodam.cfc_api_itrans.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "RenaProfissional")
@Table(name = "MF_RENA_TAB_PROFISSIONAL", schema = "TRANSITO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Profissional implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PR_CPF")
	private String cpf;

	@Column(name = "PR_NUM_INDIVIDUO")
	private Integer numeroIndividuo;

	@Column(name = "PR_NOME_PROFISSIONAL")
	private String nome;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Profissional that = (Profissional) o;
		return getCpf() != null && Objects.equals(getCpf(), that.getCpf());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
