package br.gov.am.prodam.cfc_api_itrans.controller;


import br.gov.am.prodam.cfc_api_itrans.model.dto.AlunoDTO;
import br.gov.am.prodam.cfc_api_itrans.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1")
//@Api(tags = "Alunos ativos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping(value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation("Obtem lista de todos os alunos ativos")
    @ResponseBody
    ResponseEntity<Set<AlunoDTO>> findAllAlunosValidos() {
        try {
            Set<AlunoDTO> alunos = alunoService.findAllAlunosValidos();
            return ResponseEntity.ok(alunos);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
