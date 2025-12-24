/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.service;

import br.ufmt.biblioteca.Ui.dto.AutorDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface AutorService {
     public void salvar(AutorDTO dto);
    
    public void remover(AutorDTO dto);
    
    public List<AutorDTO> listar();
}
