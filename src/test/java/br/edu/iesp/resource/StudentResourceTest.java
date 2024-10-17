package br.edu.iesp.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class StudentResourceTest {

    @Test
    void testListAllStudentsEndpoint() {
        given()
                .when().get("/students")
                .then()
                .statusCode(200);  // Verifica se o status code é 200 (OK)
    }

    @Test
    void testCreateStudentEndpoint() {
        String studentJson = """
            {
                "name": "John Doe",
                "email": "john.doe@example.com",
                "birthDate": "2000-01-01"
            }
        """;

        given()
                .contentType("application/json")
                .body(studentJson)
                .when().post("/students")
                .then()
                .statusCode(200);  // Verifica se o aluno foi criado com sucesso
    }

    @Test
    void testUpdateStudentEndpoint() {
        String studentJson = """
            {
                "name": "John Doe Updated",
                "email": "john.doe.updated@example.com",
                "birthDate": "2000-01-01"
            }
        """;

        given()
                .contentType("application/json")
                .body(studentJson)
                .when().put("/students/1")
                .then()
                .statusCode(200);  // Verifica se a atualização foi bem-sucedida
    }

    @Test
    void testDeleteStudentEndpoint() {
        given()
                .when().delete("/students/1")
                .then()
                .statusCode(204);  // Verifica se o aluno foi deletado com sucesso
    }
}
