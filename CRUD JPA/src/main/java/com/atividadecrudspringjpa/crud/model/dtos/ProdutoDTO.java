package com.atividadecrudspringjpa.crud.model.dtos;
import com.atividadecrudspringjpa.crud.model.Produto;

import java.util.Optional;


public class ProdutoDTO {
    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(Optional<Produto> produtoAchado) {}

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        preco = produto.getPreco();
    }

    public ProdutoDTO(Integer id, String nome, Double preco) {
        super();
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}