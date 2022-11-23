package com.curso.hibernate.service;

import com.curso.hibernate.dao.DetalleClienteDao;
import com.curso.hibernate.dao.DetalleClienteDaoJpa;
import com.curso.hibernate.entity.DetallesCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDetalleCliente implements DetalleClienteDao {

    @Autowired
    private DetalleClienteDaoJpa detalleCliente;

    @Override
    public Optional<DetallesCliente> buscarById(Integer id) {
        return detalleCliente.findById(id);
    }
}
