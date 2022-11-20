package com.curso.hibernate.dao;

import com.curso.hibernate.entity.Cliente;

import java.util.List;

public interface ClienteDao {

    Cliente guardarCliente(Cliente usuario);
    List<Cliente> buscarTodos();
}
