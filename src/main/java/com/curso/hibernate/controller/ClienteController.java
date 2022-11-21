package com.curso.hibernate.controller;

import com.curso.hibernate.entity.Cliente;
import com.curso.hibernate.service.ServiceCliente;
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

    @GetMapping("/guardar")
    public void saveCliente(){
        Cliente usuario = new Cliente("Marcela","Moreno","Tulancingo");
        serviceCliente.guardarCliente(usuario);

        Cliente usuario2 = new Cliente("Luz Arelly","Moreno","Pachuca");
        serviceCliente.guardarCliente(usuario2);
    }

    @GetMapping("/buscar")
    public void buscarCliente(){

        System.out.println(serviceCliente.buscarTodos());
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

        Optional<Cliente> usuario = serviceCliente.buscarById(2);
        if (usuario.isPresent()){

            Cliente cliente = usuario.get();
            int idCliente = cliente.getIdCliente();
            serviceCliente.deleteCliente(idCliente);
        }
    }

}
