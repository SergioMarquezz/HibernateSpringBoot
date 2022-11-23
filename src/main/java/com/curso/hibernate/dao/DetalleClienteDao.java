package com.curso.hibernate.dao;



import com.curso.hibernate.entity.DetallesCliente;

import java.util.Optional;

public interface DetalleClienteDao {

    Optional<DetallesCliente> buscarById(Integer id);
}
