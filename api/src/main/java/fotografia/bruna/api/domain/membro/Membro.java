package fotografia.bruna.api.domain.membro;

import fotografia.bruna.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "membros") // Anotação do JPA para definir o nome da tabela
@Entity(name = "membro") // Anotação do JPA para definir o nome da entidade
@Getter // Anotação do Lombok para gerar os getters
@NoArgsConstructor // Anotação do Lombok para gerar o construtor padrão
@AllArgsConstructor // Anotação do Lombok para gerar o construtor com todos os atributos
@EqualsAndHashCode(of = "id") // Anotação do Lombok para gerar os métodos equals e hashCode
public class Membro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação do JPA para definir a chave primária
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Enumerated(EnumType.STRING) // Anotação do JPA para definir o tipo de enumeração
    private Cargo cargo;

    @Embedded // Embeddable attribute da JPA, fica em uma classe separada e é "embutido" na classe atual.
    private Endereco endereco;

    public Membro(DadosCadastroMembro dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.cargo = dados.cargo();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMembro dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.email = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}
