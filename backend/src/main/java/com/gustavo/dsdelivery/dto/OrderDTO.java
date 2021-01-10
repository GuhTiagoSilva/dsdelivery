package com.gustavo.dsdelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.gustavo.dsdelivery.entities.Order;
import com.gustavo.dsdelivery.entities.OrderStatus;
import com.gustavo.dsdelivery.entities.Product;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Double latitude;

	private Double longitude;

	private Instant moment;

	private OrderStatus status;

	private Double total;

	private String address;

	private List<ProductDTO> products = new ArrayList<>();

	public OrderDTO(Long id, Double latitude, Double longitude, Instant moment, OrderStatus status, Double total,
			String address) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		this.total = total;
		this.address = address;
	}
	
	public OrderDTO() {
		
	}

	public OrderDTO(Order order) {
		this.id = order.getId();
		this.address = order.getAddress();
		this.latitude = order.getLatitude();
		this.longitude = order.getLongitude();
		this.moment = order.getMoment();
		this.status = order.getStatus();
	}

	public OrderDTO(Order order, List<Product> products) {
		this(order);
		products.stream().map(product -> this.products.add(new ProductDTO(product)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
