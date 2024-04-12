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
import com.audrey.bergamine.models.Nota;
import com.audrey.bergamine.services.NotaService;

@RestController
@RequestMapping(value = "/nota")
public class NotaController {
    
    @Autowired
    NotaService notaService;

    @GetMapping
    public ResponseEntity<List<Nota>>  findAll(){
        List<Nota> listNota = notaService.findAll();
        return ResponseEntity.ok().body(listNota);
    }

    // A requisição vai aceitar um ID dentro do URL
    @GetMapping(value = "/{id}") 
    public ResponseEntity<Nota> findById(@PathVariable Integer id){
        Nota obj = notaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Nota obj){
        obj = notaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body("Nota salvo com sucesso"); //Código 201
    }

    







}
