/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia;

import br.ufmt.biblioteca.Persistencia.Entidades.Emprestimo;
import java.util.List;
//como acontece isso ?
/**
 *
 * @author Usuario
 */
public interface EmprestimoPersistencia {
    public void inserir(Emprestimo emprestimo);
    
    public boolean existeCliente(String id);
    
    public void remover(int id);
    
    public void atualizar(Emprestimo emprestimo);
    
    public List<Emprestimo> buscar();
}
