package fotografia.bruna.api.domain.ensaio;

import fotografia.bruna.api.domain.cliente.ClienteRepository;
import fotografia.bruna.api.domain.membro.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaDeEnsaios {

    @Autowired
    private EnsaioRepository ensaioRepository;

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public DadosAgendamentoEnsaio agendar(DadosAgendamentoEnsaio dados) {
        if (!membroRepository.existsById(dados.idMembro()))
            throw new IllegalArgumentException("Membro não encontrado");

        if (!clienteRepository.existsById(dados.idCliente())) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        var membro = membroRepository.findById(dados.idMembro()).get();
        var cliente = clienteRepository.findById(dados.idCliente()).get();
        var ensaio = new Ensaio(null, membro, cliente, dados.data());
        ensaioRepository.save(ensaio);

        // Crie um novo objeto DadosAgendamentoEnsaio com as informações do ensaio agendado
        DadosAgendamentoEnsaio novoAgendamento = new DadosAgendamentoEnsaio(ensaio.getId(), ensaio.getMembro().getId(), ensaio.getCliente().getId(), ensaio.getData());

        return novoAgendamento;
    }


    public List<Ensaio> listarEnsaios() {
        // Aqui você pode adicionar a lógica para buscar e retornar a lista de ensaios.
        // Por exemplo, você pode chamar ensaioRepository.findAll() para buscar todos os ensaios.
        return ensaioRepository.findAll();
    }

    public Optional<Ensaio> detalharEnsaio(Long ensaioId) {
        // Aqui você pode adicionar a lógica para buscar os detalhes do ensaio com base no ID.
        // Por exemplo, você pode chamar ensaioRepository.findById(ensaioId) para buscar o ensaio pelo ID.
        return ensaioRepository.findById(ensaioId);
    }

}
