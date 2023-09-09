package fotografia.bruna.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}") // Anotação do Bean Validation para validar se o campo é um CEP válido.
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,
        String complemento,
        String numero) {

}
