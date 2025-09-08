package com.lucas.Parkable.Service;

import com.lucas.Parkable.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagasService {

    @Autowired
    private VagaRepository vagaRepository;
}
