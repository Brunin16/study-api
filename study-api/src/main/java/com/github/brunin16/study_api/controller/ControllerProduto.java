package com.github.brunin16.study_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.brunin16.study_api.model.Produto;
import com.github.brunin16.study_api.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService ps;

    @PostMapping()
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.add(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> update(Produto produto) {
        return ResponseEntity.ok().body(ps.update(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok().body(ps.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(ps.get(id));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(Long id) {
        ps.delete(id);
        return ResponseEntity.noContent().build();
    }
}
