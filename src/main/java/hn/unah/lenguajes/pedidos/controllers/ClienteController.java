package hn.unah.lenguajes.pedidos.controllers;

import hn.unah.lenguajes.pedidos.dtos.clientes.ClienteDto;
import hn.unah.lenguajes.pedidos.dtos.clientes.DireccionDto;
import hn.unah.lenguajes.pedidos.repositories.ClienteRepository;
import hn.unah.lenguajes.pedidos.repositories.DireccionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import hn.unah.lenguajes.pedidos.services.ClienteService;
import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final DireccionRepository direccionRepository;

    private final ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    ClienteController(ClienteRepository clienteRepository, DireccionRepository direccionRepository) {
        this.clienteRepository = clienteRepository;
        this.direccionRepository = direccionRepository;
    }

    @PostMapping("/crear")
    public ClienteDto crearCliente(@RequestBody ClienteDto entity) {
        return clienteService.crearNuevoCliente(entity);
    }

    @GetMapping("/obtener/todos")
    public List<ClienteDto> obtenerTodos() {
        return this.clienteService.obtenerTodos();
    }

    @PostMapping("/asociar/direccion/{cliente}")
    public String asociarDireccionCliente(@RequestBody DireccionDto direccion, @PathVariable(name="cliente") int cliente) {
        if(this.clienteService.asociarDireccionCliente(direccion, cliente) == null){
            return "El cliente no existe";
        }
        return "Dirección asociada";
    }
    
    
    
    
}
