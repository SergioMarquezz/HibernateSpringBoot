package com.curso.hibernate.controller;

import com.curso.hibernate.entity.Cliente;
import com.curso.hibernate.entity.Pedido;
import com.curso.hibernate.service.ServiceCliente;
import com.curso.hibernate.service.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.GregorianCalendar;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private ServiceCliente serviceCliente;

    @Autowired
    private ServicePedido servicePedido;


    @GetMapping("/guardar")
    public void saveCliente(){

        //Obtener cliente de la base de datos
        Cliente elCliente = serviceCliente.buscarById(3).get();

        Pedido pedidoNum1 = new Pedido(new GregorianCalendar(2021,2,6));
        Pedido pedidoNum2 = new Pedido(new GregorianCalendar(2021,4,7));
        Pedido pedidoNum3 = new Pedido(new GregorianCalendar(2021,5,8));

        pedidoNum1.setFormaPago("Tarjeta");
        pedidoNum2.setFormaPago("Referencia");
        pedidoNum3.setFormaPago("Deposito");

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

    @GetMapping("/buscar")
    public void buscarPedidosCliente(){

        //Obtener cliente de la base de datos
        Cliente elCliente = serviceCliente.buscarById(3).get();
        System.out.println("Cliente: "+elCliente);
        System.out.println("Pedidos: "+elCliente.getPedidos());
    }

}
