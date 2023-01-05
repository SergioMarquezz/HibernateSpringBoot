package com.curso.hibernate.dao;

import com.curso.hibernate.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDao {

    Cliente guardarCliente(Cliente usuario);
    List<Cliente> buscarTodos();
    Optional<Cliente> buscarById(Integer id);
    void deleteCliente(Integer id);
    void updateCliente(Cliente cliente);
}
