package com.lucas.Parkable.Service;

import com.lucas.Parkable.Repository.RegistroEstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroEstacionamentoService {

    @Autowired
    private RegistroEstacionamentoRepository registroEstacionamentoRepository;


}
