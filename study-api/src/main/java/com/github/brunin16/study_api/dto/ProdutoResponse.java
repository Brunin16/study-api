package com.github.brunin16.study_api.dto;

import com.github.brunin16.study_api.model.Produto;

import lombok.Data;

@Data
public class ProdutoResponse {
    private Long id;
    private String nome;

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getName();
    }
}
