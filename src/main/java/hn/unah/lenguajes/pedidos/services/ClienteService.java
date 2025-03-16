package hn.unah.lenguajes.pedidos.services;

import hn.unah.lenguajes.pedidos.dtos.clientes.ClienteDto;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.pedidos.entities.Cliente;
import hn.unah.lenguajes.pedidos.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto crearNuevoCliente(ClienteDto clienteDto){
        Cliente nvoCliente = new Cliente();
        nvoCliente.setNombre(clienteDto.getNombre());
        nvoCliente.setApellido(clienteDto.getApellido());
        nvoCliente.setCorreo(clienteDto.getCorreo());
        nvoCliente.setTelefono(clienteDto.getTelefono());

        Cliente save = clienteRepository.save(nvoCliente);
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

}
