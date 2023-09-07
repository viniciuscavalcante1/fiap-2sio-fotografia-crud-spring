package fotografia.bruna.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Para trabalhar com web tradicional, podemos usar @Controller ao invés de @RestController
// No MVC, o controller é uma classe que mapeia as requisições e respostas da API. É como se fosse uma rota.
// Controller é uma classe que recebe requisições e devolve respostas
@RestController // Anotação que indica que é uma classe de controle do Spring Boot
@RequestMapping("/hello") // Indica que a classe vai receber requisições na rota /hello
public class HelloController {
    @GetMapping // Indica que o método vai receber requisições do tipo GET e devolver uma resposta
    public String hello() {
        return "Hello World!";
    }
}
