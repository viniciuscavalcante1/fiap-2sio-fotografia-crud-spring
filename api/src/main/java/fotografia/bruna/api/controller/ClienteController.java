package fotografia.bruna.api.controller;

import fotografia.bruna.api.cliente.Cliente;
import fotografia.bruna.api.cliente.ClienteRepository;
import fotografia.bruna.api.cliente.DadosCadastroCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }

}
