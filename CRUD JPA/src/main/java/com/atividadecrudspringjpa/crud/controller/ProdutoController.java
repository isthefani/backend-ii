package com.atividadecrudspringjpa.crud.controller;


import com.atividadecrudspringjpa.crud.model.Produto;
import com.atividadecrudspringjpa.crud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Produto produto){
        Produto prod = produtoService.insert(produto);
        return prod !=  null ?
                new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED)
                :
                new ResponseEntity<>("Erro ao criar produto", HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = produtoService.findAllProduto();
        return !list.isEmpty() ?
                new ResponseEntity<>(list, HttpStatus.OK)
                :
                new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}
