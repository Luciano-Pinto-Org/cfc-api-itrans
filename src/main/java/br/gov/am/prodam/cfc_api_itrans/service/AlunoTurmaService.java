package br.gov.am.prodam.cfc_api_itrans.service;


import br.gov.am.prodam.cfc_api_itrans.model.AlunoTurma;
import br.gov.am.prodam.cfc_api_itrans.repository.AlunoTurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AlunoTurmaService {

    private final AlunoTurmaRepository alunoTurmaRepository;

    Set<AlunoTurma> findAllAlunosVirtuais() {
        return alunoTurmaRepository.findAllAlunosVirtuais().orElseThrow();
    }
}
