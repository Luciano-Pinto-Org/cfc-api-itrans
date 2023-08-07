package br.gov.am.prodam.cfc_api_itrans.repository;

import br.gov.am.prodam.cfc_api_itrans.model.AlunoTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface AlunoTurmaRepository extends JpaRepository<AlunoTurma, Long> {
     @Query(value = "SELECT at FROM AlunoTurma at " +
             "WHERE at.isVirtual = 'S' " +
             "AND at.servico.dataCancelamento IS NULL " +
             "AND at.servico.dataPagamento IS NOT NULL " +
             "AND CURRENT_DATE BETWEEN at.servico.dataInicioProcesso AND at.servico.dataValidadeProcesso")
    Optional<Set<AlunoTurma>> findAllAlunosVirtuais();

}
