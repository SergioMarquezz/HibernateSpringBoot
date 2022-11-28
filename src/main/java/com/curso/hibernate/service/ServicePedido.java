package com.curso.hibernate.service;

import com.curso.hibernate.dao.PedidoDao;
import com.curso.hibernate.dao.PedidoDaoJpa;
import com.curso.hibernate.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePedido implements PedidoDao {

    @Autowired
    private PedidoDaoJpa pedidoDaoJpa;

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoDaoJpa.save(pedido);
    }
}
