package com.audrey.bergamine.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.audrey.bergamine.models.Nota;
import com.audrey.bergamine.repositories.NotaRepository;

@Component
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;


    public Nota insert(Nota obj) {
        return notaRepository.save(obj);
    }

    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    public Nota findById(Integer id) {
        Optional<Nota> nota = notaRepository.findById(id);
        return nota.get();
    }


}
