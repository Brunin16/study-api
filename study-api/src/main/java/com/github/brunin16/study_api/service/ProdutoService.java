package com.github.brunin16.study_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.brunin16.study_api.model.Produto;

@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    private Long id = 1l;

    public Produto get(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Produto add(Produto produto) {
        produto.setId(id);
        id += 1;
        produtos.add(produto);
        return produto;
    }

    public List<Produto> getAll() {
        return produtos;
    }

    public void delete(Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }

    public Produto update(Produto produto) {
        return produtos.stream()
                .filter(p -> p.getId().equals(produto.getId()))
                .findFirst()
                .map(p -> {
                    p.setName(produto.getName());
                    return p;
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

}
