/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia;

import br.ufmt.biblioteca.Persistencia.Entidades.Autor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface AutorPersistencia {
      public void inserir(Autor autor);
    
    public void remover(int id);
    
    public void atualizar(Autor autor);
    
    public List<Autor> buscar();
}
