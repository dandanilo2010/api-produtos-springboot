package com.example.produtos.service;

import com.example.produtos.dto.ProdutoDTO;
import com.example.produtos.entity.CategoriaEntity;
import com.example.produtos.entity.ProdutoEntity;
import com.example.produtos.exception.ProdutoNotFoundException;
import com.example.produtos.repository.CategoriaRepository;
import com.example.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoDTO salvarDTO(ProdutoDTO produtoDTO){

        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());

        // BUSCA A CATEGORIA
        CategoriaEntity categoria = categoriaRepository
                .findById(produtoDTO.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        // SETA A CATEGORIA NO PRODUTO
        produto.setCategoria(categoria);

        ProdutoEntity salvo = produtoRepository.save(produto);

        return new ProdutoDTO(salvo);
    }

    public List<ProdutoDTO> listarDTO(){
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new) // chama o construtor do DTO
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarPorIdDTO(Long id){
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));

        return new ProdutoDTO(produto);
    }

    public ProdutoDTO atualizarDTO(Long id, ProdutoDTO produtoDTO){

        ProdutoEntity produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));

        produtoExistente.setNome(produtoDTO.getNome());
        produtoExistente.setPreco(produtoDTO.getPreco());
        produtoExistente.setQuantidade(produtoDTO.getQuantidade());

        ProdutoEntity atualizado = produtoRepository.save(produtoExistente);

        return new ProdutoDTO(atualizado);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);

    }

    public List<ProdutoDTO> buscarPorCategoria(Long categoriaId){

        List<ProdutoEntity> produtos = produtoRepository.findByCategoriaId(categoriaId);

        return produtos.stream()
                .map(ProdutoDTO:: new)
                .collect(Collectors.toList());
    }
}
