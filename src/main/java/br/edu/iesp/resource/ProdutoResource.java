package br.edu.iesp.resource;

import br.edu.iesp.model.Produto;
import br.edu.iesp.service.ProdutoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/produto")
public class ProdutoResource {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Produto listar() {
        return new Produto();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Produto incluir(Produto produto) {
        return produtoService.salvar(produto);
    }
}