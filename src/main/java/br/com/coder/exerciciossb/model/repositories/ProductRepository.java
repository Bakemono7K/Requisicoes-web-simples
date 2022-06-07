
package br.com.coder.exerciciossb.model.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.coder.exerciciossb.model.entities.Product;

@Repository
public interface ProductRepository extends  PagingAndSortingRepository<Product, Integer>{

	public Iterable<Product> findByNameContainingIgnoreCase(String partOfName);
}
