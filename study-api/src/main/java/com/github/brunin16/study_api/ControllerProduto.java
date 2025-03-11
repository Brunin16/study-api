package com.github.brunin16.study_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @PostMapping()
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.ok().body("Produto Atualizado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Produto>> find() {
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto(1l, "maca"));
        produtos.add(new Produto(2l, "banana"));
        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.noContent().build();
    }
}
