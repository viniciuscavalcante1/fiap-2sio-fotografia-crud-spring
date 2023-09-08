package fotografia.bruna.api.cliente;

public record DadosAtualizacaoCliente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone
) {
}
