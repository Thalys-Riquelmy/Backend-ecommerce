package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Carrinho;
import com.ecommerce.repository.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
    }

    public Carrinho save(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public void deleteById(Long id) {
        carrinhoRepository.deleteById(id);
    }

}
