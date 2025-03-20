package hn.unah.lenguajes.pedidos.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedidos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpedido")
    private int idPedido;

    private String estado;

    @Column(name="fechapedido")
    private LocalDate fechaPedido;

    @Column(name="fechaenvio")
    private LocalDate fechaEnvio;

    @Column(name="totalpedido")
    private double totalPedido;

    @ManyToOne
    @JoinColumn(name="idcliente", referencedColumnName = "idcliente")    
    private Cliente cliente;

    
    public Pedidos() {
    }

    public Pedidos(int idPedido, String estado, LocalDate fechaPedido, LocalDate fechaEnvio, double totalPedido,
            Cliente cliente) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.fechaEnvio = fechaEnvio;
        this.totalPedido = totalPedido;
        this.cliente = cliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

}
