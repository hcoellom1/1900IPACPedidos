package hn.unah.lenguajes.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.pedidos.entities.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer>{
    
}
