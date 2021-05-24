package com.example.orangeTalents.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orangeTalents.casadocodigo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
