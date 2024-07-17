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

import com.ecommerce.model.Carrinho;
import com.ecommerce.service.CarrinhoService;

@RestController
@RequestMapping("/api/carrinhos")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<List<Carrinho>> listarCarrinhos() {
        List<Carrinho> carrinhos = carrinhoService.findAll();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> obterCarrinhoPorId(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.findById(id);
        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Carrinho> criarCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho novoCarrinho = carrinhoService.save(carrinho);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarrinho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinhoAtualizado) {
        Carrinho carrinho = carrinhoService.findById(id);
        if (carrinho != null) {
            carrinhoAtualizado.setId(id);
            carrinho = carrinhoService.save(carrinhoAtualizado);
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarrinho(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.findById(id);
        if (carrinho != null) {
            carrinhoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
