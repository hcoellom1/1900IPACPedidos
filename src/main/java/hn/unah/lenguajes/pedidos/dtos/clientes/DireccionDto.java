package hn.unah.lenguajes.pedidos.dtos.clientes;

public class DireccionDto {
    
    private int idDireccion;

    private String ciudad;

    private String calle;

    

    public DireccionDto() {
    }



    public DireccionDto(int idDireccion, String ciudad, String calle) {
        this.idDireccion = idDireccion;
        this.ciudad = ciudad;
        this.calle = calle;
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


    
    

}
