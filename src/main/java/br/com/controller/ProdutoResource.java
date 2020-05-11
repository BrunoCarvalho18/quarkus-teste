package br.com.controller;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.dto.CadastroProdutoDTO;
import br.com.entity.Produto;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@GET
	public List<Produto> buscarTodosProdutos() {
		return Produto.listAll();
	}

	@POST
	@Transactional
	public void buscarTodosProdutos(CadastroProdutoDTO dto) {
		Produto p = new Produto();
		p.nome = dto.nome;
		p.valor = dto.valor;
		p.persist();
	}

	@PUT
	@Path("{id}")
	@Transactional
	public void alterarTodosProdutos(@PathParam("id") Long id, CadastroProdutoDTO dto) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		if (produtoOp.isPresent()) {
			Produto produto = produtoOp.get();
			produto.nome = dto.nome;
			produto.valor = dto.valor;
			produto.persist();
		} else {
			throw new NotFoundException();
		}
	}
	
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void deletarTodosProdutos(@PathParam("id") Long id) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		produtoOp.ifPresentOrElse(Produto::delete,()->{throw new NotFoundException();});
		
	}

}