package fotografia.bruna.api.domain.ensaio;

import java.time.LocalDateTime;

public record DadosListagemEnsaio(Long id, String nomeMembro, String nomeCliente, LocalDateTime data) {
    public DadosListagemEnsaio(Ensaio ensaio) {
        this(ensaio.getId(), ensaio.getMembro().getNome(), ensaio.getCliente().getNome(), ensaio.getData());
    }
}
