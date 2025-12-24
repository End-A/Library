/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia;

import br.ufmt.biblioteca.Persistencia.Entidades.LivrosEmprestados;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface LivrosEmprestadosPersistencia {
    public void inserir(LivrosEmprestados livrosEmprestados);
  
    public boolean ExisteEmprestimo(String id);
    
    public boolean ExisteLivro(String id);
    
    public void remover(int idEmprestimo, int idLivro);
    
    public void atualizar(LivrosEmprestados livrosEmprestados);
    
    public boolean existeLivroEmprestado(int idEmprestimo, int idLivro);
    
    public List<LivrosEmprestados> buscar();
}
