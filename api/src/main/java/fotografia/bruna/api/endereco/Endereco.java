package fotografia.bruna.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // Embeddable attribute da JPA, fica em uma classe separada e é "embutido" na classe atual.
@Getter // Anotação do Lombok para gerar os getters
@NoArgsConstructor // Anotação do Lombok para gerar o construtor padrão
@AllArgsConstructor // Anotação do Lombok para gerar o construtor com todos os atributos
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }
}
