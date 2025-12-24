/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Entidades;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Emprestimo {
     private int id;
     private int idCliente;
     private Date dataEmprestimo;
     private Date dataDevolucao;
     private boolean devolvido;
     
     public Emprestimo(int id, int idCliente,Date dataEmprestimo, Date dataDevolucao,boolean devolvido){
         this.idCliente = idCliente;
         this.id = id; 
         this.devolvido = devolvido;
         this.dataEmprestimo = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dataEmprestimo);  // Configura a data do empréstimo
        calendar.add(Calendar.DAY_OF_MONTH, 14);  // Adiciona 14 dias à data do empréstimo
        this.dataDevolucao = calendar.getTime();
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
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the dataEmprestimo
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * @param dataEmprestimo the dataEmprestimo to set
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the devolvido
     */
    public boolean isDevolvido() {
        return devolvido;
    }

    /**
     * @param devolvido the devolvido to set
     */
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
