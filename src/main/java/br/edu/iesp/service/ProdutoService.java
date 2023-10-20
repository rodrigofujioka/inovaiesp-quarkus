package br.edu.iesp.service;


import br.edu.iesp.model.Produto;
import br.edu.iesp.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository repository;


    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Produto atualizar(Produto produto){
        return repository.save(produto);
    }

    public void excluir(Long id){
         repository.deleteById(id);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto consultar(Long id){
        return repository.findById(id).get();
    }

    public List<Produto> consultar(String nome){
        return repository.findByNomeLikeIgnoreCase(nome);
    }

}
