/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.service;

import br.ufmt.biblioteca.Ui.dto.LivrosEmprestadosDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface LivrosEmprestadosService {
    public void salvar(LivrosEmprestadosDTO dto);
     
    public void remover(LivrosEmprestadosDTO dto);
    
    public List<LivrosEmprestadosDTO> listar();
}
