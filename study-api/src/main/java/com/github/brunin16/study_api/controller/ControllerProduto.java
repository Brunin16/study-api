package com.github.brunin16.study_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.brunin16.study_api.dto.ProdutoRequestCreate;
import com.github.brunin16.study_api.dto.ProdutoRequestUpdate;
import com.github.brunin16.study_api.dto.ProdutoResponse;
import com.github.brunin16.study_api.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequestCreate dto) {
        ProdutoResponse produto = new ProdutoResponse(produtoService.save(dto));
        return ResponseEntity.status(201).body(produto);
    }

    @PutMapping("({id})")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody ProdutoRequestUpdate dto) {
        return produtoService.update(id, dto)
                .map(produto -> {
                    ProdutoResponse response = new ProdutoResponse(produto);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        List<ProdutoResponse> l = produtoService.findAll()
                .stream()
                .map(produto -> {
                    ProdutoResponse response = new ProdutoResponse(produto);
                    return response;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(l);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(produto -> {
                    ProdutoResponse response = new ProdutoResponse(produto);
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (produtoService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
