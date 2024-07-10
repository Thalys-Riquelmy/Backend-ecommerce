package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Pagamento;
import com.ecommerce.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void deleteById(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
