package br.edu.iesp.resource;

import br.edu.iesp.dto.ProductDTO;
import br.edu.iesp.entity.Product;
import br.edu.iesp.service.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Product Resource", description = "CRUD operations for products")
public class ProductResource {

    @Inject
    ProductService productService;

    @Inject
    ModelMapper modelMapper;

    @GET
    @Operation(summary = "List all products", description = "Returns a list of all products.")
    public List<ProductDTO> listAll() {
        return productService.listAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    @Transactional
    @Operation(summary = "Create a new product", description = "Creates a new product and persists it.")
    public ProductDTO create(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productService.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Update a product", description = "Updates an existing product by ID.")
    public ProductDTO update(@PathParam("id") Long id, ProductDTO productDTO) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new WebApplicationException("Product not found", 404);
        }
        modelMapper.map(productDTO, product);
        productService.update(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Delete a product", description = "Deletes a product by ID.")
    public void delete(@PathParam("id") Long id) {
        productService.delete(id);
    }
}
