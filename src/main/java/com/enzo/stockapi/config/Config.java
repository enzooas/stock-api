package com.enzo.stockapi.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzo.stockapi.model.Produto;
import com.enzo.stockapi.repository.ProdutoRepository;

@Configuration
public class Config implements CommandLineRunner {

	private ProdutoRepository produtoRepository;

	public Config(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public void run(String...args) throws Exception {
		Produto p1 = new Produto(null, "T-Shirt", 3, 49.50, "Roupa");
		Produto p2 = new Produto(null, "Vestido", 2, 39.90, "Roupa");
		Produto p3 = new Produto(null, "Boné", 5, 29.90, "Acessório");
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}