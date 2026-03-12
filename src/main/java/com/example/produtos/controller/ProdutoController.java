package com.example.produtos.controller;

import com.example.produtos.dto.ProdutoDTO;
import com.example.produtos.entity.ProdutoEntity;
import com.example.produtos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO>criar(@Valid @RequestBody ProdutoDTO produtoDto){
        ProdutoDTO produto = produtoService.salvarDTO(produtoDto);
                return ResponseEntity.status(201).body(produto);

    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar(){
        List<ProdutoDTO> produtos = produtoService.listarDTO();
        return ResponseEntity.ok(produtos); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id){
        ProdutoDTO produto = produtoService.buscarPorIdDTO(id);
        return ResponseEntity.ok(produto); // 200 OK
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProdutoDTO>> buscarPorCategoria(@PathVariable Long categoriaId){
        List<ProdutoDTO> produtos = produtoService.buscarPorCategoria(categoriaId);
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id,
                                                @Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO atualizado = produtoService.atualizarDTO(id, produtoDTO);
        return ResponseEntity.ok(atualizado); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
