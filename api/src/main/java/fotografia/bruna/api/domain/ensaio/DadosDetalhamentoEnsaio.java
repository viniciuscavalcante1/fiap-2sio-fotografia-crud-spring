package fotografia.bruna.api.domain.ensaio;

import java.time.LocalDateTime;

public record DadosDetalhamentoEnsaio(Long id, Long idMembro, Long idCliente, LocalDateTime data) {
}
