package br.edu.iesp.service;


import br.edu.iesp.model.Produto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoService {

    private static long id = 0;

    public Produto salvar(Produto produto){
        produto.setId(++id);
        produto.setNome("Nome salvo"  + id);
        produto.setDescricao("Descricao Salva " + id);
        return produto;
    }


}
