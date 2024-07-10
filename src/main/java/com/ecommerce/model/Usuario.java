package com.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @NotNull
	 @Size(max = 100)
	 private String nomeCompleto;

	@NotNull
	@Email
	@Size(max = 100)
	private String email;

	@NotNull
	@Size(min = 8, max = 100)
	private String senha;

	@NotNull
	@Size(max = 11)
	private String cpf;

	@Size(max = 15)
	private String telefone;

	private boolean receberEmail;
	private boolean permitirNotificacoes;
	
	@NotNull
	private LocalDate dataCadastro;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecosEntrega;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> historicoCompras;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Carrinho carrinho;
        

}
