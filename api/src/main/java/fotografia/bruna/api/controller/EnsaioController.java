package fotografia.bruna.api.controller;

import fotografia.bruna.api.domain.ensaio.AgendaDeEnsaios;
import fotografia.bruna.api.domain.ensaio.DadosAgendamentoEnsaio;
import fotografia.bruna.api.domain.ensaio.DadosDetalhamentoEnsaio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ensaios")
public class EnsaioController {

    @Autowired
    private AgendaDeEnsaios agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendarEnsaio(@RequestBody @Valid DadosAgendamentoEnsaio dados) {
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEnsaio(null, null, null, null));
    }
}
