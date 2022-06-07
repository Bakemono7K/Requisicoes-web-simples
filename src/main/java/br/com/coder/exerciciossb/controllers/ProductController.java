package br.com.coder.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.coder.exerciciossb.model.entities.Product;
import br.com.coder.exerciciossb.model.repositories.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(path = "/new", method = {RequestMethod.PUT,RequestMethod.POST})
	public @ResponseBody Product newProduct(@Valid Product product) {
		product.applyDiscount();
		productRepository.save(product);
		return product;
	}
	@GetMapping(path = "getall")
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}
	@GetMapping(path = "name/{partOfName}")
	public Iterable<Product> getProductsByName(@PathVariable String partOfName){
		return productRepository.findByNameContainingIgnoreCase(partOfName);

		//findByNomeStartsWith
		//findByNomeEndsWith
		//findByNomeNotContaining
	}




	@GetMapping(path = "/page/{pageNumber}/{pageQuantity}")
	public Iterable<Product> getProductsByPage(@PathVariable int pageNumber, @PathVariable int pageQuantity){
		if (pageQuantity > 5){
			pageQuantity = 5;
		}
		Pageable page = PageRequest.of(pageNumber, pageQuantity);
	    return productRepository.findAll(page);
	}



	@GetMapping(path = "/{id}")
	public Optional<Product> getProductByIid(@PathVariable int id){
		return productRepository.findById(id);
	}
	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable int id){
		productRepository.deleteById(id);
	}


}
