package com.altasbookshop;

import org.springframework.data.jpa.repository.JpaRepository;

//This class extends Spring Boot JPA Repository
// Declate the tye of the Domain Class for the interface to recognize
public interface ProductRepository extends JpaRepository<Product, Long> {
}
