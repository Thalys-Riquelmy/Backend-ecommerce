package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.ItemPedido;
import com.ecommerce.service.ItemPedidoService;

@RestController
@RequestMapping("/api/itemPedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listarItemPedidos() {
        List<ItemPedido> itemPedidos = itemPedidoService.findAll();
        return ResponseEntity.ok(itemPedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> obterItemPedidoPorId(@PathVariable Long id) {
        ItemPedido itemPedido = itemPedidoService.findById(id);
        if (itemPedido != null) {
            return ResponseEntity.ok(itemPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido novoItemPedido = itemPedidoService.save(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado) {
        ItemPedido itemPedido = itemPedidoService.findById(id);
        if (itemPedido != null) {
            itemPedidoAtualizado.setId(id);
            itemPedido = itemPedidoService.save(itemPedidoAtualizado);
            return ResponseEntity.ok(itemPedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemPedido(@PathVariable Long id) {
        ItemPedido itemPedido = itemPedidoService.findById(id);
        if (itemPedido != null) {
            itemPedidoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
