package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Object> criarPedido(@RequestBody Pedido pedido) {
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O pedido não pode ser nulo!!");
        }
        PedidoDTO pedidoCriado = pedidoService.criarPedido(pedido);
        if (pedido != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("O Pedido foi criado com sucesso!!");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar pedido!!");
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }
}
