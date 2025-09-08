package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.Service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagasService vagasService;


    /*TODO:
    *  - Adicionar uma vaga
    *  - Listar todas as vagas
    *  - Listar vagas ocupadas
    *  - Listar vagas vazias
    *  - Remover uma vaga*/
}
