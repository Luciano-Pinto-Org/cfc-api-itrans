package br.gov.am.prodam.cfc_api_itrans.service;


import br.gov.am.prodam.cfc_api_itrans.model.AlunoTurma;
import br.gov.am.prodam.cfc_api_itrans.model.Servico;
import br.gov.am.prodam.cfc_api_itrans.model.dto.AlunoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoTurmaService alunoTurmaService;

    public Set<AlunoDTO> findAllAlunosValidos() {
        Set<AlunoDTO> alunos = new HashSet<>();

        Collection<AlunoTurma> aluTurList = alunoTurmaService.findAllAlunosVirtuais();

        aluTurList.forEach(aluTur -> {
            Servico servico = aluTur.getServico();
            LocalDate dataInicioProcesso = servico.getDataInicioProcesso();
            LocalDate dataLimiteProcesso = servico.getDataValidadeProcesso();
            LocalDate dataPagamento = servico.getDataPagamento();
            LocalDate dataCancelamento = servico.getDataCancelamento();

            if (dataPagamento == null || dataCancelamento != null) {
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate today = LocalDate.parse(LocalDate.now().format(formatter));

            if (dataInicioProcesso.isAfter(today) ||
                dataLimiteProcesso.isBefore(today)){
                return;
            }

            LocalDate aberturaRenach = LocalDate.from(servico.getDataInicioProcesso());

            AlunoDTO alunoDto = AlunoDTO
                    .builder()
                    .nome(servico.getIndividuo().getNome())
                    .cpf(servico.getIndividuo().getCpf())
                    .renach(servico.getNumFormRenach())
                    .dataNascimento(servico.getIndividuo().getDtNascimento())
                    .cep(servico.getIndividuo().getCep())
                    .complemento(servico.getIndividuo().getComplemento())
                    .logradouro(servico.getIndividuo().getLogradouro())
                    .numeroResid(servico.getIndividuo().getNumCasa())
                    .dataAberturaRenach(aberturaRenach)
                    .build();

            alunos.add(alunoDto);

        });

        return alunos;
    }
}
