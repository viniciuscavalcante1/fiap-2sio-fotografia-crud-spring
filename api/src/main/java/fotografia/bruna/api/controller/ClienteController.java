package fotografia.bruna.api.controller;

import fotografia.bruna.api.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;



    @GetMapping
    public String listarCliente(Model model) {
        List<DadosListagemCliente> clientes = repository.findAll().stream().map(DadosListagemCliente::new).collect(Collectors.toList());
        model.addAttribute("clientes", clientes);
        return "lista-clientes";
    }

    @GetMapping("/cadastrar")
    public String viewCadastrarCliente(Model model) {
        System.out.println("Exibindo formulário de cadastro de cliente");
        model.addAttribute("cliente", new DadosCadastroCliente("", "", "", ""));
        return "cadastro-cliente";
    }

    @PostMapping("/cadastrar")
    public String cadastrarCliente(Model model, @ModelAttribute("cliente") DadosCadastroCliente cliente) {
        System.out.println("Nome: " + cliente.nome());
        repository.save(new Cliente(cliente));
        model.addAttribute("cliente", cliente);
        return "redirect:/clientes"; // Nome do template HTML para o formulário de cadastro
    }



    // @PostMapping("/cadastrar")
    // @Transactional
    // public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
    //     System.out.println("Nome: ");
    //     Cliente cliente = repository.save(new Cliente(dados));
    // }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCliente(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharCliente(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesCliente(cliente));
    }
}
