package com.github.brunin16.study_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.brunin16.study_api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
