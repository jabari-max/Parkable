package com.lucas.Parkable.Controllers.UI;

import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoRequestDTO;
import com.lucas.Parkable.DTOs.Vaga.VagaRequestDTO;
import com.lucas.Parkable.Service.RegistroEstacionamentoService;
import com.lucas.Parkable.Service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui")
public class EstacionamentoControllerUI {

    @Autowired
    private VagasService vagasService;

    @Autowired
    private RegistroEstacionamentoService registroEstacionamentoService;

    @GetMapping("/dashboard")
    public String mostrarDashboard(Model model) {
        model.addAttribute("vagas", vagasService.listarTodasVagas());
        model.addAttribute("veiculosAtivos", registroEstacionamentoService.exibirRegistrosPresentes());
        model.addAttribute("vagasLivres", vagasService.listarVagasLivres());
        model.addAttribute("entradaRequest", new RegistroEstacionamentoRequestDTO(null, null, null));
        model.addAttribute("historico", registroEstacionamentoService.exibirHistorico());
        return "dashboard";
    }

    @PostMapping("/vagas/adicionar")
    public String adicionarVaga(@RequestParam String codigoVaga){
        VagaRequestDTO requestDTO = new VagaRequestDTO(codigoVaga);
        vagasService.adicionarVaga(requestDTO);
        return "redirect:/ui/dashboard";
    }

    @PostMapping("/estacionamento/registrar-entrada")
    public String registrarEntrada(RegistroEstacionamentoRequestDTO entradaRequest) {
        registroEstacionamentoService.registrarEntrada(entradaRequest);
        return "redirect:/ui/dashboard";
    }

    @PostMapping("/estacionamento/registrar-saida/{id}")
    public String registrarSaida(@PathVariable Long id) {
        registroEstacionamentoService.registrarSaida(id);
        return "redirect:/ui/dashboard";
    }
}

