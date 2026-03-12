package com.example.produtos.controller;

import com.example.produtos.dto.CategoriaDTO;
import com.example.produtos.dto.ProdutoDTO;
import com.example.produtos.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO>criar(@RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = categoriaService.salvarDTO(categoriaDTO);
        return ResponseEntity.status(201).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar(){
        List<CategoriaDTO> categorias = categoriaService.listarDTO();
        return ResponseEntity.ok(categorias); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscaPorId(@PathVariable Long id){
        CategoriaDTO categoria = categoriaService.buscarPorIdDTO(id);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id,
                                                  @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO atualizado = categoriaService.atualizarDTO(id, categoriaDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
