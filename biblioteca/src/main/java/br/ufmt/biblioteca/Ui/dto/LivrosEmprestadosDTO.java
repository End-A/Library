/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Ui.dto;

/**
 *
 * @author Usuario
 */
public class LivrosEmprestadosDTO {
     private String idEmprestimo;
     private String idLivro;
     
     public LivrosEmprestadosDTO(String idEmprestimo,String idLivro ){
         this.idEmprestimo = idEmprestimo;
         this.idLivro = idLivro;
     }

    /**
     * @return the idEmprestimo
     */
    public String getIdEmprestimo() {
        return idEmprestimo;
    }

    /**
     * @param idEmprestimo the idEmprestimo to set
     */
    public void setIdEmprestimo(String idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    /**
     * @return the idLivro
     */
    public String getIdLivro() {
        return idLivro;
    }

    /**
     * @param idLivro the idLivro to set
     */
    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }
}
