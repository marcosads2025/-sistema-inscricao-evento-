package com.meuAppevento.model;

import com.meuAppevento.dto.InscricaoDTO;
import jakarta.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    // --- AQUI ESTÁ A ADIÇÃO DO RELACIONAMENTO ---
    @ManyToOne
    @JoinColumn(name = "evento_id") // Cria a coluna da chave estrangeira no banco
    private Evento evento;

    public Inscricao(InscricaoDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.telefone = dto.getTelefone();
    }

    public Inscricao() {

    }

    // --- GETTERS E SETTERS ---

    public Long getId() {
        return id;
    }

    // É uma boa prática ter o setId também
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // --- GETTER E SETTER DO EVENTO ---
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}