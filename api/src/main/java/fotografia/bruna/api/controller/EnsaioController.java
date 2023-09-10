package fotografia.bruna.api.controller;

import fotografia.bruna.api.domain.ensaio.AgendaDeEnsaios;
import fotografia.bruna.api.domain.ensaio.DadosAgendamentoEnsaio;
import fotografia.bruna.api.domain.ensaio.DadosDetalhamentoEnsaio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ensaios")
@SecurityRequirement(name = "bearer-key")
public class EnsaioController {

    @Autowired
    private AgendaDeEnsaios agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendarEnsaio(@RequestBody @Valid DadosAgendamentoEnsaio dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }
}
