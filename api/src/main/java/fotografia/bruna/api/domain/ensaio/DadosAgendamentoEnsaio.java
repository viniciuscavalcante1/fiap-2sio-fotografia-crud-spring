package fotografia.bruna.api.domain.ensaio;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoEnsaio(
        Long idMembro,

        @NotNull
        Long idCliente,

        @NotNull
        @Future
        LocalDateTime data) {

        }

