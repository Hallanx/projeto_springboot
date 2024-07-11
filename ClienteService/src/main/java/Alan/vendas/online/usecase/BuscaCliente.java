/**
 * 
 */
package Alan.vendas.online.usecase;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import alan.vendas.online.domain.Cliente;
import alan.vendas.online.exception.EntityNotFoundException;
import alan.vendas.online.repository.IClienteRepository;

/**
 * @author alan.vaz
 *
 */
@Service
public class BuscaCliente {

	private IClienteRepository clienteRepository;
	
	public BuscaCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Page<Cliente> buscar(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}
	
	public Cliente buscarPorId(String id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Cliente.class, "id", id));
	}
	
	public Boolean isCadastrado(String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isPresent() ? true : false;
	}

	public Cliente buscarPorCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException(Cliente.class, "cpf", String.valueOf(cpf)));
	}

	
}
