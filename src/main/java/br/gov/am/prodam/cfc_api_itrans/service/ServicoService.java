package br.gov.am.prodam.cfc_api_itrans.service;


import br.gov.am.prodam.cfc_api_itrans.model.Servico;
import br.gov.am.prodam.cfc_api_itrans.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;
    public List<Servico> findAllServicosAtivos(String codServico) {
        return servicoRepository.findAll(codServico).orElseThrow((() -> new NoSuchElementException(String.format("Nenhum serviço ativo do tipo {codServico=%s} encontrado.", codServico))));
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id).orElseThrow();
    }



}
