package com.github.brunin16.study_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.brunin16.study_api.dto.ProdutoRequestCreate;
import com.github.brunin16.study_api.dto.ProdutoRequestUpdate;
import com.github.brunin16.study_api.model.Produto;
import com.github.brunin16.study_api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

       public Produto save(ProdutoRequestCreate dto) {  
        Produto produto = new Produto();
        produto.setName(dto.getNome());
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> opt = produtoRepository.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }
    public Optional<Produto> update(Long id,ProdutoRequestUpdate dto){
        if(produtoRepository.existsById(id)){
            return produtoRepository.findById(id)
            .map(produto -> {
                produto.setName(dto.getNome());
                return produtoRepository.save(produto);
            });
        }
        return null;
    }
    
}
