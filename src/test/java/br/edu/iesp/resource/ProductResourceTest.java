package br.edu.iesp.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class ProductResourceTest {

    @Test
    void testListAllProductsEndpoint() {
        given()
                .when().get("/products")
                .then()
                .statusCode(200);  // Verifica se o status code é 200 (OK)
    }

    @Test
    void testCreateProductEndpoint() {
        String productJson = """
            {
                "name": "Laptop",
                "price": 1200.0,
                "manufactureDate": "2023-01-01",
                "expirationDate": null,
                "productType": "ELECTRONICS"
            }
        """;

        given()
                .contentType("application/json")
                .body(productJson)
                .when().post("/products")
                .then()
                .statusCode(200);  // Verifica se o produto foi criado com sucesso
    }


    @Test
    void testDeleteProductEndpoint() {
        given()
                .when().delete("/products/1")
                .then()
                .statusCode(204);  // Verifica se o produto foi deletado com sucesso
    }
}
