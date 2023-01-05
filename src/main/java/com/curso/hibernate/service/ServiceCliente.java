package com.curso.hibernate.service;


import com.curso.hibernate.dao.ClienteDao;
import com.curso.hibernate.dao.ClienteDaoJpa;
import com.curso.hibernate.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCliente implements ClienteDao {

    @Autowired
    private ClienteDaoJpa daoCliente;


    @Override
    public Cliente guardarCliente(Cliente usuario) {
        return daoCliente.save(usuario);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return daoCliente.findAll();

    }

    @Override
    public Optional<Cliente> buscarById(Integer id) {
        return daoCliente.findById(id);


    }

    @Override
    public void deleteCliente(Integer id) {
        daoCliente.deleteById(id);
    }

    @Override
    public void updateCliente(Cliente cliente) {

        daoCliente.save(cliente);
    }
}
