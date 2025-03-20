package hn.unah.lenguajes.pedidos.services;

import hn.unah.lenguajes.pedidos.PedidosApplication;
import hn.unah.lenguajes.pedidos.controllers.ClienteController;
import hn.unah.lenguajes.pedidos.dtos.clientes.ClienteDto;
import hn.unah.lenguajes.pedidos.dtos.clientes.DireccionDto;
import hn.unah.lenguajes.pedidos.dtos.clientes.PedidosDto;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.pedidos.entities.Cliente;
import hn.unah.lenguajes.pedidos.entities.Direccion;
import hn.unah.lenguajes.pedidos.entities.Pedidos;
import hn.unah.lenguajes.pedidos.repositories.ClienteRepository;
import hn.unah.lenguajes.pedidos.repositories.DireccionRepository;
import hn.unah.lenguajes.pedidos.repositories.PedidoRepository;

@Service
public class ClienteService {
  
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    public ClienteDto crearNuevoCliente(ClienteDto clienteDto){
        Cliente nvoCliente = new Cliente();
        nvoCliente.setNombre(clienteDto.getNombre());
        nvoCliente.setApellido(clienteDto.getApellido());
        nvoCliente.setCorreo(clienteDto.getCorreo());
        nvoCliente.setTelefono(clienteDto.getTelefono());

        Cliente save = clienteRepository.save(nvoCliente);

        if(clienteDto.getDireccion() !=null){
            Direccion direccion = new Direccion();
            direccion.setCiudad(clienteDto.getDireccion().getCiudad());
            direccion.setCalle(clienteDto.getDireccion().getCalle());
            direccion.setCliente(nvoCliente);
            direccionRepository.save(direccion);
        }     
        
        if(clienteDto.getPedidos() !=null){
            for (PedidosDto pedido : clienteDto.getPedidos()) {
                Pedidos nvoPedido = new Pedidos();
                nvoPedido.setEstado(pedido.getEstado());
                nvoPedido.setFechaPedido(pedido.getFechaPedido());
                nvoPedido.setFechaEnvio(pedido.getFechaEnvio());
                nvoPedido.setTotalPedido(pedido.getTotalPedido());
                nvoPedido.setCliente(save);
                this.pedidoRepository.save(nvoPedido);
            }
        }

        clienteDto.setIdCliente(save.getIdCliente());
        
        return clienteDto;
    }

    public List<ClienteDto> obtenerTodos(){
        List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();

        List<ClienteDto> clientesDtos = new LinkedList<>();
        for (Cliente cliente : clientes) {
            ClienteDto cli = new ClienteDto();
            cli.setIdCliente(cliente.getIdCliente());
            cli.setNombre(cliente.getNombre());
            cli.setApellido(cliente.getApellido());
            cli.setTelefono(cliente.getTelefono());
            cli.setCorreo(cliente.getCorreo());
            
            clientesDtos.add(cli);
        }

        return clientesDtos;
    }

    public Direccion asociarDireccionCliente(DireccionDto direccion, int id){
        Cliente cliente = this.clienteRepository.findById(id).get();

        if(cliente!= null){
            Direccion nvaDireccion = new Direccion();
            nvaDireccion.setCalle(direccion.getCalle());
            nvaDireccion.setCiudad(direccion.getCiudad());
            nvaDireccion.setCliente(cliente);
            return this.direccionRepository.save(nvaDireccion);
        }

        return null;
        
    }

}
