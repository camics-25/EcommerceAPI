package com.senai.desafioAPI.repository;

import com.senai.desafioAPI.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Repository

public class ProdutoRepository {
    private final ArrayList<Produto> listaProdutos = new ArrayList<>();
    private final AtomicInteger id = new AtomicInteger();

    //Create
    public Produto create(Produto novoProduto){
        novoProduto.setId(id.getAndIncrement());
        listaProdutos.add(novoProduto);

        return novoProduto;
    }

    //Read All
    public ArrayList<Produto> findAll(){
        return listaProdutos;
    }

    //Read by id
    public Produto findById(int id){
        for (Produto produto: listaProdutos){
            if (produto.getId() == id){
                return produto;
            }
        }
        return null;
    }

    //Update
    public Produto updateAndCreate (Produto produtoAtualizado) {
        for (Produto produtoDaLista : listaProdutos){
            if (produtoDaLista.getId() == produtoAtualizado.getId()){
                produtoDaLista.setNome(produtoAtualizado.getNome());
                produtoDaLista.setDescricao(produtoAtualizado.getDescricao());
                produtoDaLista.setPreco(produtoAtualizado.getPreco());

                return produtoDaLista;
            }
        }
    listaProdutos.add(produtoAtualizado);
        return produtoAtualizado;
    }
    //Delete
    public void deleteById(int id){

        listaProdutos.removeIf(produto -> produto.getId() == id);
    }
}
