package com.atividadecrudspringjpa.crud.repository;

import com.atividadecrudspringjpa.crud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.id = :id AND p.preco <= :preco")
    Optional<Produto> findProdutoParamJpql(Integer id, Double preco);


    @Query(value="SELECT p.* FROM tb_produto p WHERE p.id = :id AND p.preco <= :preco", nativeQuery = true)
    Optional<Produto> findProdutoParamSql(Integer id, Double preco);

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    Optional<Produto> findNomeProdutoJpql(String nome);

    @Query(value="SELECT p.* FROM tb_produto p WHERE p.nome = :nome", nativeQuery = true)
    Optional<Produto> findNomeProdutoSql(String nome);

}
