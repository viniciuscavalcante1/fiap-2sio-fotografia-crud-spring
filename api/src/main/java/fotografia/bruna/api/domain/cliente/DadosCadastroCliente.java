package fotografia.bruna.api.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        String nome,
        String email,
        String cpf,
        String telefone
) {

}
