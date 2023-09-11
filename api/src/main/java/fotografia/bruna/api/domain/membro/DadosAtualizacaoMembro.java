package fotografia.bruna.api.domain.membro;

import fotografia.bruna.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMembro(
        @NotNull
        Long id,
        String nome,
        String telefone) {
}
