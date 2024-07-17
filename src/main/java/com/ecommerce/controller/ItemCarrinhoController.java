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

import com.ecommerce.model.ItemCarrinho;
import com.ecommerce.service.ItemCarrinhoService;

@RestController
@RequestMapping("/api/itemCarrinhos")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @GetMapping
    public ResponseEntity<List<ItemCarrinho>> listarItemCarrinhos() {
        List<ItemCarrinho> itemCarrinhos = itemCarrinhoService.findAll();
        return ResponseEntity.ok(itemCarrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCarrinho> obterItemCarrinhoPorId(@PathVariable Long id) {
        ItemCarrinho itemCarrinho = itemCarrinhoService.findById(id);
        if (itemCarrinho != null) {
            return ResponseEntity.ok(itemCarrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ItemCarrinho> criarItemCarrinho(@RequestBody ItemCarrinho itemCarrinho) {
        ItemCarrinho novoItemCarrinho = itemCarrinhoService.save(itemCarrinho);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemCarrinho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCarrinho> atualizarItemCarrinho(@PathVariable Long id, @RequestBody ItemCarrinho itemCarrinhoAtualizado) {
        ItemCarrinho itemCarrinho = itemCarrinhoService.findById(id);
        if (itemCarrinho != null) {
            itemCarrinhoAtualizado.setId(id);
            itemCarrinho = itemCarrinhoService.save(itemCarrinhoAtualizado);
            return ResponseEntity.ok(itemCarrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemCarrinho(@PathVariable Long id) {
        ItemCarrinho itemCarrinho = itemCarrinhoService.findById(id);
        if (itemCarrinho != null) {
            itemCarrinhoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
