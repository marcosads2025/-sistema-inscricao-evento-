package com.meuAppevento.controller;

import com.meuAppevento.dto.InscricaoDTO;
import com.meuAppevento.service.InscricaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class InscricaoController {

    private final InscricaoService service;

    public InscricaoController(InscricaoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("inscricao", new InscricaoDTO());
        return "index";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("inscricao") InscricaoDTO inscricao, Model model) {
        service.salvar(inscricao);
        model.addAttribute("sucesso", true);
        model.addAttribute("inscricao", inscricao);
        return "index";
    }
}