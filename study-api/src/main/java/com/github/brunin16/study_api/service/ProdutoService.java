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
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
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
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
            }
        }
    }

    public Produto update(Produto produto) {
        Long id = produto.getId();
        int rId = id.intValue();
        produtos.get(rId - 1).setName(produto.getName());
        return produto;
    }
}
