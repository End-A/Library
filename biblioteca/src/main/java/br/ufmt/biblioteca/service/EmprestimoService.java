/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.service;

import br.ufmt.biblioteca.Ui.dto.EmprestimoDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface EmprestimoService {
    public void salvar(EmprestimoDTO dto);
    
    public void remover(EmprestimoDTO dto);
    
    public List<EmprestimoDTO> listar();
}
