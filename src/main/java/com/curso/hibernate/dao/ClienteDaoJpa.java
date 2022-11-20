package com.curso.hibernate.dao;

import com.curso.hibernate.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteDaoJpa extends JpaRepository<Cliente,Integer> {
}
