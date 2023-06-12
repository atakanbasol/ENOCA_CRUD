package com.atakanbasol.crud.data.repository;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByNameContaining(String keyword);
    List<CustomerEntity> findByOrdersIsNull();

}
