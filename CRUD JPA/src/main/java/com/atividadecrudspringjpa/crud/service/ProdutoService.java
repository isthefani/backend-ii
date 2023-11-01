package com.atividadecrudspringjpa.crud.service;

import com.atividadecrudspringjpa.crud.model.Produto;
import com.atividadecrudspringjpa.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findAllProduto(){
        return produtoRepository.findAll();
    }

}
