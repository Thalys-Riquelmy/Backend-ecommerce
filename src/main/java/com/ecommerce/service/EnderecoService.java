package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Endereco;
import com.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {

	 @Autowired
	 private EnderecoRepository enderecoRepository;

	 public List<Endereco> findAll() {
		 return enderecoRepository.findAll();
	 }

	 public Endereco findById(Long id) {
		 return enderecoRepository.findById(id).orElse(null);
	 }

	 public Endereco save(Endereco endereco) {
		 return enderecoRepository.save(endereco);
	 }

	 public void deleteById(Long id) {
	 	enderecoRepository.deleteById(id);
	 }
}
