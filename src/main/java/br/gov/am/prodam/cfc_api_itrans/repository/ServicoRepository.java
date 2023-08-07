package br.gov.am.prodam.cfc_api_itrans.repository;

import br.gov.am.prodam.cfc_api_itrans.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query(value = "SELECT servico FROM Servico servico "
            + "WHERE servico.codServico = :codServico "
            + "AND servico.dataCancelamento IS NULL "
            + "AND servico.dataPagamento IS NOT NULL "
            + "AND CURRENT_DATE BETWEEN servico.dataInicioProcesso AND servico.dataValidadeProcesso")
    Optional<List<Servico>> findAll(@Param("codServico") String codServico);

}
