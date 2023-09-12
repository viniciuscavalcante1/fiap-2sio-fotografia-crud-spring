package fotografia.bruna.api.controller;

import fotografia.bruna.api.domain.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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

    @GetMapping("/{id}")
    public String detalharCliente(@PathVariable Long id, Model model) {
        var cliente = repository.getReferenceById(id);
        DadosDetalhesCliente dados = new DadosDetalhesCliente(cliente);
        model.addAttribute("cliente", dados);
        return "detalhes-cliente";
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
        return "redirect:/clientes"; 
    }

    @GetMapping("/{id}/editar")
    public String viewEditarCliente(@PathVariable Long id, Model model) {
        var cliente = repository.getReferenceById(id);

        DadosAtualizacaoCliente dados = new DadosAtualizacaoCliente(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getTelefone());
        model.addAttribute("cliente", dados);
        return "editar-cliente"; 
    }

    @PostMapping("/{id}/editar")
    @Transactional
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") DadosCadastroCliente dados, Model model) {
        Cliente cliente = repository.getReferenceById(id);

        cliente.atualizarInformacoes(new DadosAtualizacaoCliente(id, dados.nome(), dados.email(), dados.cpf(), dados.telefone()));
        repository.save(cliente);
        return "redirect:/clientes/" + id; 
    }

    @GetMapping("/{id}/excluir")
    public String confirmarExclusao(@PathVariable Long id, Model model) {
        var cliente = repository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        return "confirmar-exclusao"; 
    }

    @PostMapping("/{id}/excluir")
    @Transactional
    public String excluirCliente(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/clientes";
    }


}
