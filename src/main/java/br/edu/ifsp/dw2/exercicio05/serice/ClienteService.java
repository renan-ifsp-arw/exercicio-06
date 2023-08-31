package br.edu.ifsp.dw2.exercicio05.serice;

import br.edu.ifsp.dw2.exercicio05.domain.Cliente;
import br.edu.ifsp.dw2.exercicio05.domain.Endereco;
import br.edu.ifsp.dw2.exercicio05.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Optional<List<Cliente>> listar() {
        return Optional.of(clienteRepository.findAll());
    }

    public Optional<Optional<Cliente>> getById(Long id) {
        return Optional.of(clienteRepository.findById(id));
    }

    public Optional<Cliente> salvar(Cliente cliente) {
        return Optional.of(clienteRepository.save(cliente));
    }

    public void remove(Long id) { clienteRepository.deleteById(id);}

    public void update(Long id, Cliente cliente) {
        Optional<Cliente> savedCliente = clienteRepository.findById(id);
        if(savedCliente.isPresent()){
            BeanUtils.copyProperties(cliente, savedCliente, "id");
            clienteRepository.save(cliente);
        }

    }

    public void updateEndereco(Long id, Endereco endereco) {
        Optional<Cliente> savedCliente = clienteRepository.findById(id);
        savedCliente.ifPresent(cliente -> {
            cliente.setEndereco(endereco);
            clienteRepository.save(cliente);
        });

    }
}
