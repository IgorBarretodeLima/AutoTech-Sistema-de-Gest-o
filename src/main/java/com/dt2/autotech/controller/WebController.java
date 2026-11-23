package com.dt2.autotech.controller;

import com.dt2.autotech.entities.*;
import com.dt2.autotech.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final ClienteRepository clienteRepo;
    private final VeiculoRepository veiculoRepo;
    private final MecanicoRepository mecanicoRepo;
    private final PecaRepository pecaRepo;
    private final OrdemServicoRepository ordemRepo;

    public WebController(ClienteRepository clienteRepo, VeiculoRepository veiculoRepo,
                         MecanicoRepository mecanicoRepo, PecaRepository pecaRepo,
                         OrdemServicoRepository ordemRepo) {
        this.clienteRepo = clienteRepo;
        this.veiculoRepo = veiculoRepo;
        this.mecanicoRepo = mecanicoRepo;
        this.pecaRepo = pecaRepo;
        this.ordemRepo = ordemRepo;
    }

    @GetMapping("/")
    public String paginaInicial() {
        return "index";
    }

    @GetMapping("/servicos")
    public String paginaServicos(Model model) {
        model.addAttribute("ordens", ordemRepo.findAll());
        model.addAttribute("clientes", clienteRepo.findAll());
        model.addAttribute("veiculos", veiculoRepo.findAll());
        model.addAttribute("mecanicos", mecanicoRepo.findAll());
        model.addAttribute("pecas", pecaRepo.findAll());
        return "servicos";
    }

    @PostMapping("/salvar-cliente")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteRepo.save(cliente);
        return "redirect:/";
    }

    @PostMapping("/salvar-veiculo")
    public String salvarVeiculo(@ModelAttribute Veiculo veiculo) {
        veiculoRepo.save(veiculo);
        return "redirect:/";
    }

    @PostMapping("/salvar-mecanico")
    public String salvarMecanico(@ModelAttribute Mecanico mecanico) {
        mecanicoRepo.save(mecanico);
        return "redirect:/";
    }

    @PostMapping("/salvar-peca")
    public String salvarPeca(@ModelAttribute Peca peca) {
        pecaRepo.save(peca);
        return "redirect:/";
    }

    @PostMapping("/salvar-ordem")
    public String salvarOrdem(@ModelAttribute OrdemServico ordem) {
        ordemRepo.save(ordem);
        return "redirect:/servicos";
    }
}