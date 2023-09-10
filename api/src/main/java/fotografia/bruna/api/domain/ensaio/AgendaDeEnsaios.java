package fotografia.bruna.api.domain.ensaio;

import fotografia.bruna.api.domain.cliente.ClienteRepository;
import fotografia.bruna.api.domain.membro.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeEnsaios {

    @Autowired
    private EnsaioRepository ensaioRepository;

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void agendar(DadosAgendamentoEnsaio dados) {
        if (!membroRepository.existsById(dados.idMembro()))
            throw new IllegalArgumentException("Membro não encontrado");

        if (!clienteRepository.existsById(dados.idCliente())) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        var membro = membroRepository.findById(dados.idMembro()).get();
        var cliente = clienteRepository.findById(dados.idCliente()).get();
        var consulta = new Ensaio(null, membro, cliente, dados.data());
        ensaioRepository.save(consulta);
    }
}
