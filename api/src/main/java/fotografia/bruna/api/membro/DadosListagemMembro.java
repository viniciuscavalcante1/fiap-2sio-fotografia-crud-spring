package fotografia.bruna.api.membro;

public record DadosListagemMembro(String nome, String email, Cargo cargo) {

    public DadosListagemMembro(Membro membro) {
        this(membro.getNome(), membro.getEmail(), membro.getCargo());
    }
}
