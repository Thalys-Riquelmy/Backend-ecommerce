package com.ecommerce.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(max = 100)
    private String pais;

    @NotNull
    @Size(max = 100)
    private String estado;

    @NotNull
    @Size(max = 100)
    private String cidade;

    @NotNull
    @Size(max = 100)
    private String bairro;

    @NotNull
    @Size(max = 10)
    private String cep;

    @NotNull
    @Size(max = 200)
    private String rua;

    @NotNull
    @Size(max = 10)
    private String numero;

    @Size(max = 200)
    private String complemento;

    @Size(max = 500)
    private String observacao;
	

}
