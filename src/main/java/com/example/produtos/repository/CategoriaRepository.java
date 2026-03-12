package com.example.produtos.repository;

import com.example.produtos.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
