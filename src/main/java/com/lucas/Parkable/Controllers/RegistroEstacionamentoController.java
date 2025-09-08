package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.Service.RegistroEstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estacionamento")
public class RegistroEstacionamentoController {

    @Autowired
    private RegistroEstacionamentoService registroEstacionamentoService;

    /*TODO:
    *  - Adicionar um carro
    *  - Alterar um carro
    *  - Exibir carros por placa
    *  - Registrar hora de saída (aplicar regra de negócio do preço a pagar)
    *  - Listar apenas carros
    *  - Listar apenas motos*/
}
