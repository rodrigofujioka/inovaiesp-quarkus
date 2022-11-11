package br.edu.iesp.service;


import br.edu.iesp.model.Produto;
import br.edu.iesp.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository repository;


    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Produto atualizar(Produto produto){
        if(Objects.isNull(produto.getId())){

        }
        return repository.save(produto);
    }

    public void excluir(Long id){
         repository.deleteById(id);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

}
