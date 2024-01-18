package com.generation.gamestore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.generation.gamestore.model.Categoria;
import com.generation.gamestore.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
        if (categoriaRepository.existsById(id)) {
            categoriaAtualizada.setId(id);
            return categoriaRepository.save(categoriaAtualizada);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
