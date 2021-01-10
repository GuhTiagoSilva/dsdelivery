package com.gustavo.dsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.dsdelivery.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
