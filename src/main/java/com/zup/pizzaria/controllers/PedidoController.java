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
        ResponseEntity<Object> pedidoCriado = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(pedidoCriado.getStatusCode()).body(pedidoCriado.getBody());
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarPedido(@PathVariable(value = "id") Long id){
        try{
            pedidoService.removerPedido(id);
            return ResponseEntity.status(HttpStatus.OK).body("Pedido excluído do banco de dados!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir!");
        }
    }
}
