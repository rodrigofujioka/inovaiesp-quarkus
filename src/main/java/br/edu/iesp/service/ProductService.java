package br.edu.iesp.service;

import br.edu.iesp.entity.Product;
import br.edu.iesp.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.listAll();
    }

    @Transactional
    public void save(Product product) {
        productRepository.persist(product);
    }

    @Transactional
    public void update(Product product) {
        productRepository.getEntityManager().merge(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }
}
