/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Entidades;

/**
 *
 * @author Usuario
 */
public class Autor {
    private int id;
    private String nome;
    private String biografia;

    
    public Autor(int id,String nome, String biografia){
             this.id = id;
             this.nome = nome;
             this.biografia = biografia;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the biografia
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * @param biografia the biografia to set
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
  
}
