/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.service;

import br.ufmt.biblioteca.Ui.dto.ClienteDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ClienteService {
    public void salvar(ClienteDTO dto);
    
    public void remover(ClienteDTO dto);
    
    public List<ClienteDTO> listar();
}
