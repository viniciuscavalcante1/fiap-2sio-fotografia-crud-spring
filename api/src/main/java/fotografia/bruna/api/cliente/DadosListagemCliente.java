package fotografia.bruna.api.cliente;

public record DadosListagemCliente(String nome, String email, String cpf, String telefone) {
    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getTelefone());
    }
}
