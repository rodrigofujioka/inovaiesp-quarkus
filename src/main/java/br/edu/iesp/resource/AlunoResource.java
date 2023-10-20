package br.edu.iesp.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/aluno")
public class AlunoResource {

    @GET
     public String nomeAluno(){
         return "Rodrigo Fujioka";
     }

}
