package com.atividadecrudspringjpa.crud.service;

import com.atividadecrudspringjpa.crud.model.Produto;
import com.atividadecrudspringjpa.crud.model.dtos.ProdutoDTO;
import com.atividadecrudspringjpa.crud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO insert(ProdutoDTO produtoDTO){
        Produto prod = new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getPreco());
        return new ProdutoDTO(produtoRepository.save(prod));
    }

    public List<Produto> findAllProduto(){
        return produtoRepository.findAll();
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> list = produtoRepository.findAll();
        return list.stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());

    }

    public Optional<ProdutoDTO> findById(Integer id) {
        Optional<Produto> produtoId = produtoRepository.findById(id);
        Optional<ProdutoDTO> produtoIdDTO = Optional.of(new ProdutoDTO(produtoId));

        return produtoIdDTO;
    }

    public void delete(Integer id) {
        produtoRepository.deleteById(id);

    }

    public Optional<ProdutoDTO> findByNameJpql(String nome) {
        Optional<Produto> prod = produtoRepository.findNomeProdutoJpql(nome);
        Optional<ProdutoDTO> prodDto = Optional.of(new ProdutoDTO(prod));
        return prodDto;
    }

    public Optional<ProdutoDTO> findByNameSql(String nome) {
        Optional<Produto> prod = produtoRepository.findNomeProdutoSql(nome);
        Optional<ProdutoDTO> prodDTO = Optional.of(new ProdutoDTO(prod));
        return prodDTO;
    }

}
