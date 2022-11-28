package com.curso.hibernate.controller;

import com.curso.hibernate.entity.Cliente;
import com.curso.hibernate.entity.DetallesCliente;
import com.curso.hibernate.entity.Pedido;
import com.curso.hibernate.service.ServiceCliente;
import com.curso.hibernate.service.ServiceDetalleCliente;
import com.curso.hibernate.service.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class CrearPedidosCliente {

    @Autowired
    private ServiceCliente serviceCliente;

    @Autowired
    private ServicePedido servicePedido;


    @GetMapping("/guardar")
    public void saveCliente(){

        //Obtener cliente de la base de datos
        Cliente elCliente = serviceCliente.buscarById(2).get();

        Pedido pedidoNum1 = new Pedido(new Date(120,6,4));
        Pedido pedidoNum2 = new Pedido(new Date(120,5,3));
        Pedido pedidoNum3 = new Pedido(new Date(120,7,2));

        pedidoNum1.setCliente(elCliente);
        pedidoNum2.setCliente(elCliente);
        pedidoNum3.setCliente(elCliente);

        pedidoNum1.getCliente().setIdCliente(elCliente.getIdCliente());
        pedidoNum2.getCliente().setIdCliente(elCliente.getIdCliente());
        pedidoNum3.getCliente().setIdCliente(elCliente.getIdCliente());

        elCliente.agregarPedido(pedidoNum1);
        elCliente.agregarPedido(pedidoNum2);
        elCliente.agregarPedido(pedidoNum3);


        servicePedido.guardarPedido(pedidoNum1);
        servicePedido.guardarPedido(pedidoNum2);
        servicePedido.guardarPedido(pedidoNum3);

    }

}
