package com.github.brunin16.study_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.brunin16.study_api.model.Produto;
import com.github.brunin16.study_api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> get(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto add(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        Produto produto = get(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }    

    public Produto update(Long id, Produto produto) {
        Produto old = get(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setId(id); // garante que vai atualizar o registro correto
        return add(produto); // reutiliza método de salvar
    }
    
}
