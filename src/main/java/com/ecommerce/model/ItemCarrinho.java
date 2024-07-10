package com.ecommerce.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "itens_carrinho")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinho {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @NotNull
	 @ManyToOne
	 private Produto produto;
	 
	 @NotNull
	 @ManyToOne
	 private Carrinho carrinho;

	 @NotNull
	 private int quantidade;

	 @NotNull
	 private BigDecimal precoUnitario;

     private BigDecimal precoTotal;
}
