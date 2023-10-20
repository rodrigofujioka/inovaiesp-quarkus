package br.edu.iesp.resource;

import br.edu.iesp.model.Produto;
import br.edu.iesp.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/produto")
public class ProdutoResource {
    @Inject
    ProdutoService produtoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar() {
      return produtoService.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluir(Produto produto) {
        return Response
                .ok(produtoService.salvar(produto))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Produto produto){
        return Response
                .ok(produtoService.atualizar(produto))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id){
        produtoService.excluir(id);
        return Response.ok().build();
    }
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(@PathParam("id") Long id){
        return Response
                .ok(produtoService.consultar(id))
                .build();
    }

    @GET
    @Path("/nome/{nome}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(@PathParam("nome") String nome){
        return Response
                .ok(produtoService.consultar(nome))
                .build();
    }

}