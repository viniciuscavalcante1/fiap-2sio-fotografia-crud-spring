package fotografia.bruna.api.controller;

import fotografia.bruna.api.membro.DadosCadastroMembro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
public class MembrosController {
    @PostMapping
    // Esse é o padrão de projeto chamado DTO (Data Transfer Object)
    public void cadastrarMembro(@RequestBody DadosCadastroMembro dados) { // @RequestBody indica que o método vai receber um JSON no corpo da requisição
        System.out.println(dados);
    }

}
