package br.edu.iesp.repository;

import br.edu.iesp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository
        extends JpaRepository<Produto, Long> {

    @Query("select p from Produto p where p.nome like %:nome%")
    List<Produto> findByNomeLikeIgnoreCase(@Param("nome") String nome);

}
