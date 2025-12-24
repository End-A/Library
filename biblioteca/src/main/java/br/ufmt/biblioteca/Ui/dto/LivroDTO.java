/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Ui.dto;

/**
 *
 * @author Usuario
 */
public class LivroDTO {
    private String id;
    private String titulo;
    private String idAutor;
    private String resumo;
    private boolean disponivel;

    public LivroDTO(String id,String titulo,String idAutor, String resumo,boolean disponivel){
        this.disponivel = disponivel;
        this.id = id;
        this.idAutor = idAutor;
        this.resumo = resumo;
        this.titulo = titulo;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the idAutor
     */
    public String getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the disponivel
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the disponivel to set
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
