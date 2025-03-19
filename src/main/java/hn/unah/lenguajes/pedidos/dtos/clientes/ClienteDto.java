package hn.unah.lenguajes.pedidos.dtos.clientes;

import java.util.List;

public class ClienteDto {    
    
    private int idCliente;
    
    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    private DireccionDto direccion;

    private List<PedidosDto> pedidos;

    public ClienteDto() {
    }

    public ClienteDto(String nombre, String apellido, String correo, String telefono, DireccionDto direccionDto) {        
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccionDto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

    public List<PedidosDto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidosDto> pedidos) {
        this.pedidos = pedidos;
    }

    

    

    


}
