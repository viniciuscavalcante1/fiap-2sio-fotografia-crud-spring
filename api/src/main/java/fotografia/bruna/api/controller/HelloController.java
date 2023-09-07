package fotografia.bruna.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// para trabalhar com web tradicional, podemos usar @Controller ao invés de @RestController
// Controller é uma classe que recebe requisições e devolve respostas
@RestController // anotação que indica que é uma classe de controle do Spring Boot
@RequestMapping("/hello") // indica que a classe vai receber requisições na rota /hello
public class HelloController {
    @GetMapping // indica que o método vai receber requisições do tipo GET e devolver uma resposta
    public String hello() {
        return "Hello World!";
    }
}
