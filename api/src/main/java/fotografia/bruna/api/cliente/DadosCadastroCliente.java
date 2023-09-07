package fotografia.bruna.api.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank @Pattern(regexp = "\\d{10,11}")
        String cpf,

        @NotBlank @Pattern(regexp = "\\d{8,13}")
        String telefone
) {

}
