package com.audrey.bergamine.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.audrey.bergamine.models.Aluno;
import com.audrey.bergamine.services.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>>  findAll(){
        List<Aluno> listAluno = alunoService.findAll();
        return ResponseEntity.ok().body(listAluno);
    }

    // A requisição vai aceitar um ID dentro do URL
    @GetMapping(value = "/{id}") 
    public ResponseEntity<Aluno> findById(@PathVariable Integer id){
        Aluno obj = alunoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Aluno obj){
        obj = alunoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body("Aluno salvo com sucesso"); //Código 201
    }

    







}
