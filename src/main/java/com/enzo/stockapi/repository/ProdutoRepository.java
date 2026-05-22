package com.enzo.stockapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enzo.stockapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}