package com.gustavo.dsdelivery.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.dsdelivery.dto.OrderDTO;
import com.gustavo.dsdelivery.dto.ProductDTO;
import com.gustavo.dsdelivery.entities.Order;
import com.gustavo.dsdelivery.entities.Product;
import com.gustavo.dsdelivery.repositories.OrderRepository;
import com.gustavo.dsdelivery.repositories.ProductRepository;
import com.gustavo.dsdelivery.services.exceptions.DatabaseException;
import com.gustavo.dsdelivery.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();
		copyDtoToEntity(order, dto);
		order = repository.save(order);
		return new OrderDTO(order, order.getProducts());
	}

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Optional<Order> order = repository.findById(id);
		Order entity = order.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new OrderDTO(entity, entity.getProducts());
	}

	@Transactional
	public OrderDTO update(Long id, OrderDTO dto) {
		try {
			Order order = repository.getOne(id);
			copyDtoToEntity(order, dto);
			order = repository.save(order);
			return new OrderDTO(order);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found");
		}

	}

	public void delete(Long id) {
		try {
			Order order = repository.getOne(id);
			repository.delete(order);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private void copyDtoToEntity(Order order, OrderDTO dto) {
		order.setAddress(dto.getAddress());
		order.setLatitude(dto.getLatitude());
		order.setLongitude(dto.getLongitude());
		order.setMoment(dto.getMoment());

		for (ProductDTO productDTO : dto.getProducts()) {
			Product product = productRepository.getOne(productDTO.getId());
			order.getProducts().add(product);
		}

		order.setStatus(dto.getStatus());
		order.setTotal(dto.getTotal());

	}

}
