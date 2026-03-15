package com.meuAppevento.service;

import com.meuAppevento.dto.InscricaoDTO;
import com.meuAppevento.model.Inscricao;
import com.meuAppevento.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {

    private final InscricaoRepository repository;

    public InscricaoService(InscricaoRepository repository) {
        this.repository = repository;
    }

    public void salvar(InscricaoDTO dto) {

//        Inscricao inscricao = new Inscricao();

//        inscricao.setNome(dto.getNome());
//        inscricao.setEmail(dto.getEmail());
//        inscricao.setTelefone(dto.getTelefone());

        // ← ESTA LINHA É O QUE FALTAVA

        repository.save(new Inscricao(dto));
    }
}