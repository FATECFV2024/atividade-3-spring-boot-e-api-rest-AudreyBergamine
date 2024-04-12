package com.audrey.bergamine.models;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Nota implements Serializable { 

    // Transforma o objeto em bits para percorrer a rede 
    private static final long serialVersionUID = 1L;
    
    private

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Integer id;

    Double logica_e_Programacao;
    Double banco_de_Dados;
    Double desenv_Web;

    @JsonIgnore
    @OneToOne(mappedBy = "nota")
    Aluno aluno;


    //  CONSTRUTORES
    public Nota(){}    

    public Nota(Integer id, Double logica_e_Programacao, Double banco_de_Dados, Double desenv_Web) {
        this.id = id;
        this.logica_e_Programacao = logica_e_Programacao;
        this.banco_de_Dados = banco_de_Dados;
        this.desenv_Web = desenv_Web;
    }



    // GETTERS AND SETTERS
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLogica_e_Programacao() {
        return logica_e_Programacao;
    }

    public void setLogica_e_Programacao(Double logica_e_Programacao) {
        this.logica_e_Programacao = logica_e_Programacao;
    }

    public Double getBanco_de_Dados() {
        return banco_de_Dados;
    }

    public void setBanco_de_Dados(Double banco_de_Dados) {
        this.banco_de_Dados = banco_de_Dados;
    }

    public Double getDesenv_Web() {
        return desenv_Web;
    }

    public void setDesenv_Web(Double desenv_Web) {
        this.desenv_Web = desenv_Web;
    }

    // HASH CODE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nota other = (Nota) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
       
}
