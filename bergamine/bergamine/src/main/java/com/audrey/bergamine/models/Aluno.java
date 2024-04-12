package com.audrey.bergamine.models;

import java.io.Serializable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Aluno implements Serializable { 

    // Transforma o objeto em bits para percorrer a rede 
    private static final long serialVersionUID = 1L;
    
    private

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nome;

    Integer idade;

    String curso;

    Boolean matriculado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fk_Nota", referencedColumnName = "id")
    Nota nota;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fk_Endereco", referencedColumnName = "id")
    Endereco endereco;    


    //  CONSTRUTORES
    public Aluno() {}


    public Aluno(Integer id, String nome, Integer idade, String curso, Boolean matriculado, Nota nota, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.matriculado = matriculado;
        this.nota = nota;
        this.endereco = endereco;
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


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getIdade() {
        return idade;
    }


    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public String getCurso() {
        return curso;
    }


    public void setCurso(String curso) {
        this.curso = curso;
    }


    public Boolean getMatriculado() {
        return matriculado;
    }


    public void setMatriculado(Boolean matriculado) {
        this.matriculado = matriculado;
    }

    public Nota getNota() {
        return nota;
    }


    public void setNota(Nota nota) {
        this.nota = nota;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        Aluno other = (Aluno) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }




       
}
