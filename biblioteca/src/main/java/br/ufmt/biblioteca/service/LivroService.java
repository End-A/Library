/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.service;

import br.ufmt.biblioteca.Ui.dto.LivroDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface LivroService {
    public void salvar(LivroDTO dto);
    
    public void remover(LivroDTO dto);
    
    public List<LivroDTO> listar();
}
