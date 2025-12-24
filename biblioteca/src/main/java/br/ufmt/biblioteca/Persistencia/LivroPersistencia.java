/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia;

import br.ufmt.biblioteca.Persistencia.Entidades.Livro;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface LivroPersistencia {
    public void inserir(Livro livro);
    
    public void remover(int id);
    
    public boolean existeAutor(String id);
  
    
    public void atualizar(Livro livro);
    
    public List<Livro> buscar();
}
