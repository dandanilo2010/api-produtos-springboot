package com.example.produtos.dto;

import com.example.produtos.entity.ProdutoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "O preço é obrigatório")
    private Double preco;

    @NotNull(message = "Quantidade é obrigatória")
    private Integer quantidade;

    private CategoriaDTO categoria;

    public ProdutoDTO(ProdutoEntity produtoEntity){
        this.id = produtoEntity.getId();
        this.nome = produtoEntity.getNome();
        this.preco = produtoEntity.getPreco();
        this.quantidade = produtoEntity.getQuantidade();

        if(produtoEntity.getCategoria() != null){
            this.categoria = new CategoriaDTO((produtoEntity.getCategoria()));
        }
    }


}


