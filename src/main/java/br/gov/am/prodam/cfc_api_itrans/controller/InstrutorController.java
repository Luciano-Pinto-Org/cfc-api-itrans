package br.gov.am.prodam.cfc_api_itrans.controller;


import br.gov.am.prodam.cfc_api_itrans.model.dto.InstrutorDTO;
import br.gov.am.prodam.cfc_api_itrans.service.InstrutorService;
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
public class InstrutorController {

    private final InstrutorService instrutorService;


    @GetMapping(value = "/instrutores", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation("Obtem lista de todos os alunos ativos")
    @ResponseBody
    ResponseEntity<Set<InstrutorDTO>> findAllInstrutoresCredenciados() {
        try {
            Set<InstrutorDTO> instrutores = instrutorService.findAllInstrutores();
            return ResponseEntity.ok(instrutores);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
