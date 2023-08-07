package br.gov.am.prodam.cfc_api_itrans.service;

import br.gov.am.prodam.cfc_api_itrans.model.Credenciamento;
import br.gov.am.prodam.cfc_api_itrans.model.Individuo;
import br.gov.am.prodam.cfc_api_itrans.model.Profissional;
import br.gov.am.prodam.cfc_api_itrans.model.dto.InstrutorDTO;
import br.gov.am.prodam.cfc_api_itrans.model.enums.TipoEntidade;
import br.gov.am.prodam.cfc_api_itrans.model.enums.TipoProfissional;
import br.gov.am.prodam.cfc_api_itrans.repository.CredenciamentoRepository;
import br.gov.am.prodam.cfc_api_itrans.repository.IndividuoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InstrutorService {
    private final CredenciamentoRepository credRepo;
    private final IndividuoRepository individuoRepo;

    public Set<InstrutorDTO> findAllInstrutores() {
        Set<InstrutorDTO> instrutores = new HashSet<>();

        Set<Credenciamento> credenciamentos = credRepo.findByTipoEntidadeAndTipoProfissional(TipoEntidade.CFC_TEORICO.getCode(), TipoProfissional.INSTRUTOR_TRANSITO.getCode());

        credenciamentos.forEach(credenciamento -> {
            Profissional profissional = credenciamento.getProfissional();
            Optional<Individuo> individuoOpt = individuoRepo.findById(profissional.getNumeroIndividuo().longValue());

            if (individuoOpt.isPresent()) {
                Individuo individuo = individuoOpt.get();

                InstrutorDTO instrutorDto = InstrutorDTO
                        .builder()
                        .nome(profissional.getNome())
                        .cpf(profissional.getCpf())
                        .dtNascimento(individuo.getDtNascimento())
                        .logradouro(individuo.getLogradouro())
                        .numCasa(individuo.getNumCasa())
                        .complemento(individuo.getComplemento())
                        .cep(individuo.getCep())
                        .build();

                instrutores.add(instrutorDto);
            }


        });

        return instrutores;
    }
}
