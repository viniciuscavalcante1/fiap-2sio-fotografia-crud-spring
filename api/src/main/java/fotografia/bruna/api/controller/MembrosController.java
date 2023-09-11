package fotografia.bruna.api.controller;

import fotografia.bruna.api.domain.endereco.DadosEndereco;
import fotografia.bruna.api.domain.endereco.Endereco;
import fotografia.bruna.api.domain.membro.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/membros")
public class MembrosController {

    @Autowired // Injeção de dependência
    private MembroRepository repository;

    @GetMapping
    public String listarMembro(Model model) {
        List<DadosListagemMembro> membros = repository.findAll().stream().map(DadosListagemMembro::new).collect(Collectors.toList());
        model.addAttribute("membros", membros);
        return "lista-membros"; // Nome do template HTML para a lista de membros
    }

    @GetMapping("/{id}")
    public String detalharMembro(@PathVariable Long id, Model model) {
        var membro = repository.getReferenceById(id);
        DadosDetalhesMembro dados = new DadosDetalhesMembro(membro);
        model.addAttribute("membro", dados);
        return "detalhes-membro"; // Nome do template HTML para os detalhes do membro
    }

    @GetMapping("/cadastrar")
    // O cargo é um ENUM e só pode ser um dos valores definidos na classe Cargo: FOTOGRAFA, EDITORA, ASSISTENTE
    public String viewCadastrarMembro(Model model) {
        System.out.println("Exibindo formulário de cadastro de membro");
        model.addAttribute("membro", new DadosCadastroMembro("", "", "", "", null, new DadosEndereco("", "", "", "", "", "", ""))); // Substitua os campos vazios pelos campos desejados
        return "cadastro-membro";
    }

    @PostMapping("/cadastrar")
    @Transactional
    public String cadastrarMembro(Model model, @ModelAttribute("membro") DadosCadastroMembro membro) {
        System.out.println("Nome: " + membro.nome());
        repository.save(new Membro(membro));
        model.addAttribute("membro", membro);
        return "redirect:/membros"; // Nome do template HTML para o formulário de cadastro
    }

    @GetMapping("/{id}/editar")
    public String viewEditarMembro(@PathVariable Long id, Model model) {
        var membro = repository.getReferenceById(id);
        DadosAtualizacaoMembro dados = new DadosAtualizacaoMembro(membro.getId(), membro.getNome(), membro.getTelefone());
        model.addAttribute("membro", dados);
        return "editar-membro"; // Nome do template HTML para o formulário de edição
    }

    @PostMapping("/{id}/editar")
    @Transactional
    public String atualizarMembro(@PathVariable Long id, @ModelAttribute("membro") DadosCadastroMembro dados, Model model) {
        Membro membro = repository.getReferenceById(id);

        membro.atualizarInformacoes(new DadosAtualizacaoMembro(id, dados.nome(), dados.telefone()));
        repository.save(membro);
        return "redirect:/membros/" + id; // Nome do template HTML para a página de detalhes do membro
    }

    @GetMapping("/{id}/excluir")
    public String confirmarExclusao(@PathVariable Long id, Model model) {
        // Aqui você pode buscar os dados do membro por ID para exibir na página de confirmação
        var membro = repository.getReferenceById(id);
        model.addAttribute("membro", membro);
        return "confirmar-exclusao-membro"; // Nome do template HTML para a página de confirmação de exclusão
    }

    @PostMapping("/{id}/excluir")
    @Transactional
    public String excluirMembro(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/membros";
    }
}
