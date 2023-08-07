package br.gov.am.prodam.cfc_api_itrans.repository;

import br.gov.am.prodam.cfc_api_itrans.model.Credenciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CredenciamentoRepository extends JpaRepository<Credenciamento, Long> {


    @Query("FROM Credenciamento cred " +
            "WHERE cred.tipoEntidade = :tipoEntidade " +
            "AND cred.tipoProfissional = :tipoProfissional " +
            "AND cred.dataInicio <= CURRENT_DATE " +
            "AND cred.dataFim >= CURRENT_DATE")
    Set<Credenciamento> findByTipoEntidadeAndTipoProfissional(String tipoEntidade, String tipoProfissional);
}
