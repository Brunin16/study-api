package com.github.brunin16.study_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @PostMapping
    public ResponseEntity<String> create() {
        return ResponseEntity.status(HttpStatus.CREATED).body("produto Criado");
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.ok().body("Produto Atualizado com sucesso");
    }

    @GetMapping
    public ResponseEntity<String> find() {
        return ResponseEntity.ok().body("'content':{\n    'name':maçã,\n    'name':banana\n}");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.noContent().build();
    }
}
