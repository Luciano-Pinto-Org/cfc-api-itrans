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
@Table(name = "CFC_DISCIPLINA", schema = "TRANSITO")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Disciplina implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Long id;

	@Column
	private String descricao;

	@Column
	private Character ativo;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Disciplina that = (Disciplina) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}


