package fotografia.bruna.api.controller;

import fotografia.bruna.api.domain.cliente.Cliente;
import fotografia.bruna.api.domain.cliente.ClienteRepository;
import fotografia.bruna.api.domain.ensaio.*;
import fotografia.bruna.api.domain.membro.Membro;
import fotografia.bruna.api.domain.membro.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ensaios")
public class EnsaioController {

    @Autowired
    private AgendaDeEnsaios agenda;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private EnsaioRepository ensaioRepository;

    @GetMapping
    public String listarEnsaio(Model model) {
        List<DadosListagemEnsaio> ensaios = agenda.listarEnsaios().stream().map(DadosListagemEnsaio::new).collect(Collectors.toList());
        model.addAttribute("ensaios", ensaios);
        return "lista-ensaios"; // Nome do template HTML para a lista de ensaios
    }

    @GetMapping("/agendar")
    public String viewAgendarEnsaio(Model model) {
        System.out.println("Exibindo formulário de agendamento de ensaio");

        // Crie um objeto DadosAgendamentoEnsaio vazio para preencher o formulário
        DadosAgendamentoEnsaio dadosAgendamento = new DadosAgendamentoEnsaio(null, null, null, null);
        List<Cliente> clientes = clienteRepository.findAll();
        List<Membro> membros = membroRepository.findAll();

        model.addAttribute("dadosAgendamentoEnsaio", dadosAgendamento);
        model.addAttribute("clientes", clientes);
        model.addAttribute("membros", membros);

        // Você também pode adicionar outros dados ao modelo, se necessário.

        return "agendar-ensaio";
    }

    @PostMapping("/agendar")
    public String agendarEnsaio(Model model, @ModelAttribute("dadosAgendamentoEnsaio") DadosAgendamentoEnsaio dadosAgendamentoEnsaio) {
            // Processar os dados do agendamento do ensaio
            DadosAgendamentoEnsaio novoAgendamento = agenda.agendar(dadosAgendamentoEnsaio);
            return "redirect:/ensaios";
    }


}
    /* @GetMapping("/{id}")
    public String detalharEnsaio(@PathVariable Long id, Model model) {
        var ensaio = agenda.detalharEnsaio(id);
        DadosDetalhamentoEnsaio dados = new DadosDetalhamentoEnsaio(ensaio);
        model.addAttribute("ensaio", dados);
        return "detalhes-ensaio"; // Nome do template HTML para os detalhes do ensaio
    }

    @GetMapping("/{id}/editar")
    public String viewEditarEnsaio(@PathVariable Long id, Model model) {
        var ensaio = agenda.detalharEnsaio(id);
        DadosEdicaoEnsaio dados = new DadosEdicaoEnsaio(ensaio);
        model.addAttribute("ensaio", dados);
        return "editar-ensaio"; // Nome do template HTML para o formulário de edição
    }

    @PostMapping("/{id}/editar")
    @Transactional
    public String editarEnsaio(@PathVariable Long id, @ModelAttribute("ensaio") DadosEdicaoEnsaio dados, Model model) {
        Ensaio ensaio = agenda.detalharEnsaio(id);

        ensaio.editarInformacoes(dados);
        agenda.salvarEnsaio(ensaio);
        return "redirect:/ensaios/" + id; // Nome do template HTML para a página de detalhes do ensaio
    }

    @GetMapping("/{id}/excluir")
    public String confirmarExclusao(@PathVariable Long id, Model model) {
        // Aqui você pode buscar os dados do ensaio por ID para exibir na página de confirmação
        var ensaio = agenda.detalharEnsaio(id);
        model.addAttribute("ensaio", ensaio);
        return "confirmar-exclusao-ensaio"; // Nome do template HTML para a página de confirmação de exclusão
    }

    @PostMapping("/{id}/excluir")
    @Transactional
    public String excluirEnsaio(@PathVariable Long id) {
        agenda.excluirEnsaio(id);
        return "redirect:/ensaios";
    }

     */

