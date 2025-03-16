package hn.unah.lenguajes.pedidos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.pedidos.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    
    public Cliente findByCorreo(String correo);
}
