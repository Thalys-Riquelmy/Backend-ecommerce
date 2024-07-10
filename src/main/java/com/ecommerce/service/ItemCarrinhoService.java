package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.ItemCarrinho;
import com.ecommerce.repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {
	
	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;
	
	public List<ItemCarrinho> findAll(){
		return itemCarrinhoRepository.findAll();
	}
	
	public ItemCarrinho findById(Long id) {
		return itemCarrinhoRepository.findById(id).orElse(null);
	}
	
	public ItemCarrinho save(ItemCarrinho itemCarrinho) {
		return itemCarrinhoRepository.save(itemCarrinho);
	}
	
	public void deleteById(Long id) {
		itemCarrinhoRepository.deleteById(id);
	}

}
