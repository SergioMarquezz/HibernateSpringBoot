package com.curso.hibernate.controller;

import com.curso.hibernate.entity.Cliente;
import com.curso.hibernate.entity.DetallesCliente;
import com.curso.hibernate.service.ServiceCliente;
import com.curso.hibernate.service.ServiceDetalleCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ServiceCliente serviceCliente;
    @Autowired
    private ServiceDetalleCliente clienteDetalleService;

    @GetMapping("/guardar")
    public void saveCliente(){
        Cliente usuario = new Cliente("Marcela","Moreno","Tulancingo");
        DetallesCliente detallesUsuario = new DetallesCliente("www.facebook.com","5534292267","Segundo detalle Cliente");

        //Asociar los objetos para guardar en BD
        usuario.setClientesDetalle(detallesUsuario);
        serviceCliente.guardarCliente(usuario);

       /* Cliente usuario2 = new Cliente("Luz Arelly","Moreno","Pachuca");
        serviceCliente.guardarCliente(usuario2);*/
    }

    @GetMapping("/buscar")
    public void buscarCliente(){

        Optional<DetallesCliente> detalles = clienteDetalleService.buscarById(2);
        DetallesCliente clienteDetalle = detalles.get();

        System.out.println(clienteDetalle);
        System.out.println(clienteDetalle.getElCliente());

       // System.out.println(serviceCliente.buscarTodos());
    }

    @GetMapping("/actualizar")
    public void actualizarCliente(){

        Optional<Cliente> usuario = serviceCliente.buscarById(2);
        if (usuario.isPresent()){

            Cliente cliente = usuario.get();
            cliente.setNombreCliente("Alberto");
            serviceCliente.guardarCliente(cliente);
        }
    }

    @GetMapping("/borrar")
    public void borrarCliente(){

        Optional<Cliente> usuario = serviceCliente.buscarById(1);
        if (usuario.isPresent()){

            Cliente cliente = usuario.get();
            int idCliente = cliente.getIdCliente();
            serviceCliente.deleteCliente(idCliente);
        }
    }

}
