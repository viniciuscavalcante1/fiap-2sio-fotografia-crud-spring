package fotografia.bruna.api.membro;

import fotografia.bruna.api.endereco.DadosEndereco;
import fotografia.bruna.api.endereco.Endereco;

public record DadosDetalhesMembro(Long id, String nome, String email, Cargo cargo) {
    public DadosDetalhesMembro(Membro membro) {
        this(membro.getId(), membro.getNome(), membro.getEmail(), membro.getCargo());
    }

}


