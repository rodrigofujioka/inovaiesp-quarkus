package br.edu.iesp.resource;


import br.edu.iesp.entity.Festa;
import br.edu.iesp.entity.Student;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/festas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Festa Resource com os endpoints para festas",
        description = "CRUD com operações para festa ")
public class FestaResource {

    @GET
    @Operation(summary = "Lista as festas do InovaIesp",
            description = "Retorna lista de festas ")
    public List<Festa> listar(){
        return Festa.listAll();
    }


    @POST
    @Transactional
    @Operation(summary = "Cria uma festa no banco",
            description = "Retorna a festa persistida ")
    public Festa criar(Festa festa){
        festa.persist();
        return festa;
    }


}
