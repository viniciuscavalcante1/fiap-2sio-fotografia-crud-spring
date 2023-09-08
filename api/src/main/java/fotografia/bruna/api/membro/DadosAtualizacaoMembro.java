package fotografia.bruna.api.membro;

import fotografia.bruna.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMembro(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
