package com.curso.hibernate.conexion;

import com.curso.hibernate.entity.Cliente;
import com.curso.hibernate.service.ServiceCliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    //@Autowired
   // private static ServiceCliente serviceCliente;
    /*public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/pruebashibernante?useSSL=false";
        String user = "root";
        String contrasenia="";


        try{
            System.out.println("Conectando a base de datos: " + url);

            Connection conexion = DriverManager.getConnection(url,user,contrasenia);
            System.out.println("Conexion exitosa");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }*/

    public static void main(String[] args){
        ServiceCliente serviceCliente = new ServiceCliente();

        Cliente usuario = new Cliente("Sergio","Marquez","Toriello Guerra");
        serviceCliente.guardarCliente(usuario);


    }
}
