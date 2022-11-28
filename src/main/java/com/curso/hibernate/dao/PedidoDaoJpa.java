package com.curso.hibernate.dao;

import com.curso.hibernate.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDaoJpa extends JpaRepository<Pedido, Integer> {
}
