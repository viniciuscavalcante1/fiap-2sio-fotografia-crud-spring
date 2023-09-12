package fotografia.bruna.api.domain.ensaio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record DadosAgendamentoEnsaio(
        @JsonProperty("id") Long id,
        @JsonProperty("idMembro") Long idMembro,
        @JsonProperty("idCliente") Long idCliente,
        @JsonProperty("data") LocalDateTime data) {

    @JsonCreator
    public DadosAgendamentoEnsaio(
            @JsonProperty("id") Long id,
            @JsonProperty("idMembro") Long idMembro,
            @JsonProperty("idCliente") Long idCliente,
            @JsonProperty("data") LocalDateTime data) {
        this.id = id;
        this.idMembro = idMembro;
        this.idCliente = idCliente;
        this.data = data;
    }
}
