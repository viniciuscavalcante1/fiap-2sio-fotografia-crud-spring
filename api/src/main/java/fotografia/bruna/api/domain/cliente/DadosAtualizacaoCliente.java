package fotografia.bruna.api.domain.cliente;

public record DadosAtualizacaoCliente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone
) {
}
