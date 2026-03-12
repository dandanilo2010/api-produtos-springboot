package com.example.produtos.repository;

import com.example.produtos.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoriaId(Long categoriaId);
}
