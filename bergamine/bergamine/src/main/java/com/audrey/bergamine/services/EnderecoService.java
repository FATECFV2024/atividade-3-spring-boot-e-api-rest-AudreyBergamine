package com.audrey.bergamine.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.audrey.bergamine.models.Endereco;
import com.audrey.bergamine.repositories.EnderecoRepository;

@Component
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco insert(Endereco obj) {
        return enderecoRepository.save(obj);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.get();
    }


}
