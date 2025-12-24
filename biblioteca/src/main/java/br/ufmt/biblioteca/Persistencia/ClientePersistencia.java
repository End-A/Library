/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia;

import br.ufmt.biblioteca.Persistencia.Entidades.Cliente;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface ClientePersistencia {
    public void inserir(Cliente cliente);
     
    public boolean existeClienteComCpf(String cpf);
    
    public void remover(int id);
    
    public void atualizar(Cliente cliente);
    
    public List<Cliente> buscar();
}
