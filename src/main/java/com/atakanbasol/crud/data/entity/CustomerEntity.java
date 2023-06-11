package com.atakanbasol.crud.data.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> order;

}
