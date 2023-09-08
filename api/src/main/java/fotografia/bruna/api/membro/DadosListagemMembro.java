package fotografia.bruna.api.membro;

public record DadosListagemMembro(Long id, String nome, String email, Cargo cargo) {

    public DadosListagemMembro(Membro membro) {
        this(membro.getId(), membro.getNome(), membro.getEmail(), membro.getCargo());
    }
}
