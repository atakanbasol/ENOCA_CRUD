package com.atakanbasol.crud.data.repository;

import com.atakanbasol.crud.data.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
