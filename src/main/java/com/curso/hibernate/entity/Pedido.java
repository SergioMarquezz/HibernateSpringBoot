package com.curso.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fechaPago")
    private Date fecha;
    @Column(name = "pagoFoma")
    private String formaPago;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public Pedido(Date fecha) {
        this.fecha = fecha;
    }

    public Pedido() {}

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", formaPago='" + formaPago + '\'' +
                '}';
    }
}
