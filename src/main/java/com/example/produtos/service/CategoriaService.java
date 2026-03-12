package com.example.produtos.service;

import com.example.produtos.dto.CategoriaDTO;
import com.example.produtos.entity.CategoriaEntity;
import com.example.produtos.exception.ProdutoNotFoundException;
import com.example.produtos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaDTO salvarDTO(CategoriaDTO categoriaDTO){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNome(categoriaDTO.getNome());

        CategoriaEntity salvo = categoriaRepository.save(categoria);

        return new CategoriaDTO(salvo);
    }

    public List<CategoriaDTO> listarDTO(){
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaDTO::new) // chama o construtor do DTO
                .collect(Collectors.toList());
    }

    public CategoriaDTO buscarPorIdDTO(Long id){
        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Categoria não encontrada"));

        return new CategoriaDTO(categoria);

    }

    public CategoriaDTO atualizarDTO(Long id, CategoriaDTO categoriaDTO){
        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoria.setNome(categoriaDTO.getNome());

        CategoriaEntity atualizado = categoriaRepository.save(categoria);

        return new CategoriaDTO(atualizado);
    }

    public void deletar(Long id){
        CategoriaEntity categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaRepository.delete(categoria);

    }
}
