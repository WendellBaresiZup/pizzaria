package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PagamentoRepository pagamentoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, PagamentoRepository pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public ResponseEntity<Object> criarPedido(Pedido pedido) {
        validacoesPedido(pedido);
        pedidoRepository.save(pedido);

        // Obtenho cliente
        Cliente cliente = clienteRepository.findById(pedido.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        PedidoDTO pedidoDTO = new PedidoDTO(cliente.getNome(), cliente.getEmail(), pedido.getDescricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Pedido cadastrado com sucesso!!", "Dados do Pedido:git", pedidoDTO));
    }

    public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    public ResponseEntity<String> validacoesPedido(Pedido pedido){
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O pedido não pode ser nulo!!");
        }
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body("O Pedido foi criado com sucesso!!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o cliente!!");
        }
    }


    @Transactional
    public void removerPedido(Long pedidoId){
        pagamentoRepository.deleteByPedidoId(pedidoId);
        pedidoRepository.deleteById(pedidoId);
    }
}
