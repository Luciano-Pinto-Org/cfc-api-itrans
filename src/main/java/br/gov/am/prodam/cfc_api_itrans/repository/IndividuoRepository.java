package br.gov.am.prodam.cfc_api_itrans.repository;

import br.gov.am.prodam.cfc_api_itrans.model.Individuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuo, Long> {
}
