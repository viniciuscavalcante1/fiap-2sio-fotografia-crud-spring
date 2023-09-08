package fotografia.bruna.api.membro;

public record DadosDetalhesMembro(Long id, String nome, String email, Cargo cargo) {
    public DadosDetalhesMembro(Membro membro) {
        this(membro.getId(), membro.getNome(), membro.getEmail(), membro.getCargo());
    }

}
