/**
 * 
 */
package alan.vendas.online.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import alan.vendas.online.domain.Produto;
import alan.vendas.online.domain.Produto.Status;
import alan.vendas.online.exception.EntityNotFoundException;
import alan.vendas.online.repository.IProdutoRepository;

/**
 * @author alan.vaz
 *
 */
@Service
public class BuscaProduto {

	private IProdutoRepository produtoRepository;
	
	
	public BuscaProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Page<Produto> buscar(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}
	
	public Page<Produto> buscar(Pageable pageable, Status status) {
		return produtoRepository.findAllByStatus(pageable, status);
	}

	public Produto buscarPorCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
	}

	
}
