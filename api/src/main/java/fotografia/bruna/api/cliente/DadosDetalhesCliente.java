package fotografia.bruna.api.cliente;


public record DadosDetalhesCliente(Long id, String nome, String email, String telefone, String cpf) {
    public DadosDetalhesCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf());
    }
}
