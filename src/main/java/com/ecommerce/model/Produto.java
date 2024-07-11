package com.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name="produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String sku;

    @NotNull
    @Size(min = 2, max = 100)
    private String nome;

    @Size(max = 1000)
    private String descricao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Categoria subCategoria;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precoAtacado;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precoVarejo;

    private BigDecimal precoPromocional;

    @Min(0)
    private int quantidadeEstoque;

    private String marca;

    private String modelo;

    @Min(0)
    private double peso;  // em kg

    private String dimensoes;  // "30x20x10 cm"
    private String cor;
    private String corSecundaria;
    private String material;
    private LocalDate dataDeCadastro;
    private String status;
    private List<String> imagens;  // URLs das imagens
    private String metaTitulo;
    private String metaDescricao;
    private String metaKeywords;
    private String origem;
    private String fabricante;

    @Min(0)
    @Max(5)
    private int avaliacaoMedia;

    @Min(0)
    private int numeroDeAvaliacoes;

    private boolean emPromocao;
    private LocalDate dataInicioPromocao;
    private LocalDate dataFimPromocao;
}
