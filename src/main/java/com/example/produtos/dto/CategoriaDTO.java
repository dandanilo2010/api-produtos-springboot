package com.example.produtos.dto;

import com.example.produtos.entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;
    private String nome;

    public CategoriaDTO(CategoriaEntity categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
