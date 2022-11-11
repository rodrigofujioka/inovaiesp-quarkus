package br.edu.iesp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/aluno")
public class AlunoResource {

    @GET
     public String nomeAluno(){
         return "Rodrigo Fujioka";
     }

}
