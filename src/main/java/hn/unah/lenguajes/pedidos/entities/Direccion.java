package hn.unah.lenguajes.pedidos.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddireccion")
    private int idDireccion;

    private String ciudad;

    private String calle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idcliente", referencedColumnName = "idcliente")
    private Cliente cliente;

    public Direccion() {
    }

    public Direccion(int idDireccion, String ciudad, String calle, Cliente cliente) {
        this.idDireccion = idDireccion;
        this.ciudad = ciudad;
        this.calle = calle;
        this.cliente = cliente;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
