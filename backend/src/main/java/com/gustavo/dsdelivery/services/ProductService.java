package com.gustavo.dsdelivery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.dsdelivery.dto.ProductDTO;
import com.gustavo.dsdelivery.entities.Product;
import com.gustavo.dsdelivery.repositories.ProductRepository;
import com.gustavo.dsdelivery.services.exceptions.DatabaseException;
import com.gustavo.dsdelivery.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product product = new Product();
		copyDtoToEntity(product, dto);
		product = repository.save(product);
		return new ProductDTO(product);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		Product product = repository.getOne(id);
		copyDtoToEntity(product, dto);
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById (Long id) {
		Optional<Product> product = repository.findById(id);
		Product entity = product.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new ProductDTO(entity);
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private void copyDtoToEntity(Product product, ProductDTO dto) {
		product.setDescription(dto.getDescription());
		product.setImageUri(dto.getImageUri());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
	}

}
