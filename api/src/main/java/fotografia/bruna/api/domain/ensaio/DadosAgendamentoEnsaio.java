package fotografia.bruna.api.domain.ensaio;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoEnsaio(
        Long id,
        Long idMembro,

        @NotNull
        Long idCliente,

        @NotNull
        @Future
        LocalDateTime data) {

    public DadosAgendamentoEnsaio(Ensaio ensaio) {
        this(ensaio.getId(), ensaio.getMembro().getId(), ensaio.getCliente().getId(), ensaio.getData());
    }
}

