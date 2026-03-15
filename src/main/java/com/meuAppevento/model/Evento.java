package com.meuAppevento.model;

import jakarta.persistence.*;

// 1. ADICIONADO: Importações necessárias para a Lista (logo abaixo dos outros imports)
import java.util.List;
import java.util.ArrayList;

@Entity // Diz ao Spring que esta classe vai virar uma tabela no banco
@Table(name = "tb_eventos") // (Opcional) Dá um nome específico para a tabela
public class Evento {

    @Id // Define que este é o identificador único (Chave Primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco vai gerar o ID automaticamente (1, 2, 3...)
    private Long id;

    @Column(nullable = false, length = 100) // Coluna obrigatória e com tamanho máximo de 100 caracteres
    private String nome;

    @Column(nullable = false)
    private String descricao;

    // 2. ADICIONADO: O atributo que representa a lista de inscrições e a anotação @OneToMany
    // Fica logo abaixo dos seus outros atributos e antes do construtor
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscricao> inscricoes = new ArrayList<>();

    // Construtor vazio (obrigatório para o JPA)
    public Evento() {

    }

    // --- GETTERS E SETTERS ---
    // Eles são necessários para o Spring acessar e modificar os dados

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // 3. ADICIONADO: Os métodos Getter e Setter da nova lista de inscrições
    // Fica lá no final, junto com os outros getters e setters
    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}