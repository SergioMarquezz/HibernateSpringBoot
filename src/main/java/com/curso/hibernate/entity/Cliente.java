package com.curso.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCliente;
    @Column(name = "nombre")
    private String nombreCliente;
    @Column(name = "apellidos")
    private String apellidosCliente;
    @Column(name = "direccion")
    private String direccionCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private DetallesCliente clientesDetalle;

    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH })
    private List<Pedido> pedidos;

    public Cliente() {}

    public Cliente(String nombreCliente, String apellidosCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
    }

    public void agregarPedido(Pedido elPedido){

        if (pedidos == null){
            pedidos = new ArrayList<>();
            pedidos.add(elPedido);

            elPedido.setCliente(this);
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public DetallesCliente getClientesDetalle() {
        return clientesDetalle;
    }

    public void setClientesDetalle(DetallesCliente clientesDetalle) {
        this.clientesDetalle = clientesDetalle;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidosCliente='" + apellidosCliente + '\'' +
                ", direccionCliente='" + direccionCliente + '\'' +
                '}';
    }
}
