package com.curso.hibernate.dao;


import com.curso.hibernate.entity.DetallesCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleClienteDaoJpa extends JpaRepository<DetallesCliente,Integer> {
}
