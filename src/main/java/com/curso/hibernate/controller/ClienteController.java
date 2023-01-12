package com.curso.hibernate.controller;

import com.curso.hibernate.entity.Cliente;
import com.curso.hibernate.entity.DetallesCliente;
import com.curso.hibernate.service.ServiceCliente;
import com.curso.hibernate.service.ServiceDetalleCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        Cliente usuarioDavid = new Cliente("David","Maldonado","Tulancingo","davidM@gmail.com");
     //   DetallesCliente detallesUsuario = new DetallesCliente("www.facebook.com","5534292267","Segundo detalle Cliente");
        Cliente usuarioSandra = new Cliente("Sandra","López","Mexico","sandyL@gmail.com");
        Cliente usuarioMaria = new Cliente("María","Gómez","Pachuca","mariL@gmail.com");
        Cliente usuarioAntonio= new Cliente("Antonio","Fernández","Santiago","fernandezA@gmail.com");
        Cliente usuarioAlicia = new Cliente("Alicia","Martín","Queretaro","aliciaM@gmail.com");
        //Asociar los objetos para guardar en BD
       // usuario.setClientesDetalle(detallesUsuario);
        serviceCliente.guardarCliente(usuarioSandra);
        serviceCliente.guardarCliente(usuarioMaria);
        serviceCliente.guardarCliente(usuarioAntonio);
        serviceCliente.guardarCliente(usuarioAlicia);
        serviceCliente.guardarCliente(usuarioDavid);

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

    @GetMapping("/lista")
    public String listaCliente(Model model){

        List<Cliente> losClientes = serviceCliente.buscarTodos();
        model.addAttribute("clientes",losClientes);

        return "views/lista-clientes";
    }

    @GetMapping("/showFormAgregar")
    public String showAgregarClientes(Model model){

        Cliente elCliente = new Cliente();
        model.addAttribute("cliente",elCliente);

        return "views/agregar-clientes";
    }

    @PostMapping("/insertarCliente")
    public String agregarCliente(@ModelAttribute("cliente") Cliente elCliente){

        serviceCliente.guardarCliente(elCliente);

        return "redirect:/clientes/lista";
    }

    @GetMapping("/editar/{id}")
    public String showUpdateCliente(Model model, @PathVariable int id){

        Optional<Cliente> usuario = serviceCliente.buscarById(id);
        if (usuario.isPresent()){

            Cliente cliente = usuario.get();
            model.addAttribute("cliente",cliente);
        }
        return "views/editar-cliente";
    }

    @PostMapping("/updateCliente")
    public String editarCliente(@ModelAttribute("cliente") Cliente elCliente){

        Cliente user = new Cliente();
        user = serviceCliente.buscarById(elCliente.getIdCliente()).get();
        user.setNombreCliente(elCliente.getNombreCliente());
        user.setApellidosCliente(elCliente.getApellidosCliente());
        user.setEmail(elCliente.getEmail());
        user.setDireccionCliente(elCliente.getDireccionCliente());

        serviceCliente.updateCliente(user);

        return "redirect:/clientes/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {

        Cliente usuario = new Cliente();
        usuario = serviceCliente.buscarById(id).get();

        serviceCliente.deleteCliente(usuario.getIdCliente());

        return "redirect:/clientes/lista";
    }

}
