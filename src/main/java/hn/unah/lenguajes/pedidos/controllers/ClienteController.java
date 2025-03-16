package hn.unah.lenguajes.pedidos.controllers;

import hn.unah.lenguajes.pedidos.dtos.clientes.ClienteDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import hn.unah.lenguajes.pedidos.services.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ClienteDto crearCliente(@RequestBody ClienteDto entity) {
        return clienteService.crearNuevoCliente(entity);
    }

    @GetMapping("/obtener/todos")
    public List<ClienteDto> obtenerTodos() {
        return this.clienteService.obtenerTodos();
    }
    
    
    
}
