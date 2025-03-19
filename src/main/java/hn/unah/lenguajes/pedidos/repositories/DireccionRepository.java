package hn.unah.lenguajes.pedidos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.pedidos.entities.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, Integer> {
    
}
