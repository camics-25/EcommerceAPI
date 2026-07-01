package com.senai.desafioAPI.controller;

import com.senai.desafioAPI.model.Produto;
import com.senai.desafioAPI.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
    private final ProdutoRepository repository = new ProdutoRepository();

    //Create
    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return repository.create(produto);
    }
    //Read
    @GetMapping
    public ArrayList<Produto> getAll(){
        return repository.findAll();
    }
    //byId
    @GetMapping("/{id}")
    public Produto getById(@PathVariable int id){
        return repository.findById(id);
    }
    //Update
    @PutMapping("/{id}")
    public Produto update(@RequestBody Produto produto) {
        return repository.updateAndCreate(produto);
    }
    //Delete
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {repository.deleteById(id);}
}
