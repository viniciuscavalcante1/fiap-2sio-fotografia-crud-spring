package fotografia.bruna.api.domain.ensaio;

import fotografia.bruna.api.domain.cliente.Cliente;
import fotografia.bruna.api.domain.membro.Membro;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "ensaios")
@Entity(name = "Ensaio")
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ensaio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDateTime data;
}
