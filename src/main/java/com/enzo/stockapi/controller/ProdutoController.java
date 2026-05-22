package com.enzo.stockapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzo.stockapi.model.Produto;
import com.enzo.stockapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@GetMapping
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}
	
	@PostMapping
	public Produto saveAll(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Produto update(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
		Produto produtoExistente = produtoRepository.findById(id).get();
		
		produtoExistente.setNome(produtoAtualizado.getNome());
		produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
		produtoExistente.setPreco(produtoAtualizado.getPreco());
		produtoExistente.setCategoria(produtoAtualizado.getCategoria());
		
		return produtoRepository.save(produtoExistente);
	}
}