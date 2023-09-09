package fotografia.bruna.api.domain.membro;

import fotografia.bruna.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Usamos um record para representar um objeto imutável, que é o caso de um membro cadastrado.
// O record é usado porque ele já implementa os métodos equals, hashCode, toString e outros de forma automática.
public record DadosCadastroMembro(
        @NotNull // Anotação do Bean Validation para validar se o campo não é nulo.
        @NotBlank // Anotação do Bean Validation para validar se o campo não é vazio.
        String nome,

        @NotNull
        @NotBlank
        @Email // Anotação do Bean Validation para validar se o campo é um e-mail válido.
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{8,13}")
        String telefone,

        @NotNull
        @NotBlank
        @Pattern(regexp = "\\d{10,11}") // Anotação do Bean Validation para validar se o campo é um CPF válido.
        String cpf,

        @NotNull
        Cargo cargo,

        @NotNull
        @Valid // Anotação do Bean Validation para validar se o campo é válido de acordo com as anotações do DadosEndereco.
        DadosEndereco endereco) {
}
