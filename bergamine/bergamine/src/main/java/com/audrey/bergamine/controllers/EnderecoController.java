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
import com.audrey.bergamine.models.Endereco;
import com.audrey.bergamine.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    
    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>>  findAll(){
        List<Endereco> listEndereco = enderecoService.findAll();
        return ResponseEntity.ok().body(listEndereco);
    }

    // A requisição vai aceitar um ID dentro do URL
    @GetMapping(value = "/{id}") 
    public ResponseEntity<Endereco> findById(@PathVariable Integer id){
        Endereco obj = enderecoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Endereco obj){
        obj = enderecoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body("Endereco salvo com sucesso"); //Código 201
    }

    







}
