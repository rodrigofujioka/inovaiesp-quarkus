package br.edu.iesp.resource;

import br.edu.iesp.dto.StudentDTO;
import br.edu.iesp.entity.Student;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Student Resource", description = "CRUD operations for students")
public class StudentResource {

    private final ModelMapper modelMapper = new ModelMapper();  // Instancia o ModelMapper

    // Lista todos os alunos
    @GET
    @Operation(summary = "List all students", description = "Returns a list of all students.")
    public List<StudentDTO> listAll() {
        return Student.listAll().stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    // Cria um novo aluno
    @POST
    @Transactional
    @Operation(summary = "Create a new student", description = "Creates a new student and persists it.")
    public StudentDTO create(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        student.persist();  // Persiste diretamente no banco de dados
        return modelMapper.map(student, StudentDTO.class);
    }

    // Atualiza um aluno existente
    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Update a student", description = "Updates an existing student by ID.")
    public StudentDTO update(@PathParam("id") Long id, StudentDTO studentDTO) {
        Student student = Student.findById(id);  // Busca o aluno pelo ID
        if (student == null) {
            throw new WebApplicationException("Student not found", 404);
        }
        modelMapper.map(studentDTO, student);  // Atualiza os dados do aluno
        return modelMapper.map(student, StudentDTO.class);
    }

    // Deleta um aluno por ID
    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Delete a student", description = "Deletes a student by ID.")
    public void delete(@PathParam("id") Long id) {
        Student student = Student.findById(id);  // Verifica se o aluno existe
        if (student == null) {
            throw new WebApplicationException("Student not found", 404);
        }
        student.delete();  // Deleta o aluno
    }

    @GET
    @Path("/order-by-birthdate")
    @Operation(summary = "List students ordered by birth date", description = "Returns a list of students ordered by birth date (newest to oldest).")
    public List<StudentDTO> listAllOrderedByBirthDate() {
        return Student.list("ORDER BY birthDate DESC").stream()  // Ordena pela data de nascimento em ordem decrescente
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/order-by-name")
    @Operation(summary = "List students ordered by name", description = "Returns a list of students ordered by name.")
    public List<StudentDTO> listAllOrderedByName() {
        return Student.list("ORDER BY name").stream()  // Ordena pelo nome em ordem alfabética
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }
}
