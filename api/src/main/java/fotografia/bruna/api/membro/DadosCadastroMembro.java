package fotografia.bruna.api.membro;

import fotografia.bruna.api.endereco.DadosEndereco;

// Usamos um record para representar um objeto imutável, que é o caso de um membro cadastrado.
// O record é usado porque ele já implementa os métodos equals, hashCode, toString e outros de forma automática.
public record DadosCadastroMembro(String nome, String email, String cpf, Cargo cargo,DadosEndereco endereco) {
}
