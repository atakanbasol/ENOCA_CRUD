package com.atakanbasol.crud.data.repository;

import com.atakanbasol.crud.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByOrderDateAfter(LocalDate orderDate);

    OrderEntity findByCustomerId(Long id);
}

