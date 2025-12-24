/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.service.Impl;

import br.ufmt.biblioteca.Persistencia.ClientePersistencia;
import br.ufmt.biblioteca.Persistencia.Entidades.Cliente;
import br.ufmt.biblioteca.Persistencia.Impl.ClientePersistenciaImpl;
import br.ufmt.biblioteca.Ui.dto.ClienteDTO;
import br.ufmt.biblioteca.service.ClienteService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteServiceImpl implements ClienteService {
    private ClientePersistencia clientePersistencia = new ClientePersistenciaImpl() ;
    @Override
    public void salvar(ClienteDTO dto) {
       
        System.out.println(dto.getEmail());
        if (!dto.getEmail().contains("@")) {
         throw new RuntimeException("O email deve conter o caractere '@'.");
        } 
// sim, agora nao foi mais o email
        
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório!");
        }
        if (dto.getCpf() == null || dto.getCpf().isEmpty()) {
            throw new RuntimeException("CPF é obrigatório!");
        }
        
       
        int id = 0;
        
        if (!dto.getId().equals("")) {
            id = Integer.parseInt(dto.getId());
        }
        //nao tinha visto kkkkk
        Cliente pessoa = new Cliente(id, dto.getCpf(),dto.getNome(),dto.getEmail(), dto.getTelefone());
        
     
        ClientePersistencia persistencia = new ClientePersistenciaImpl();

       if (id == 0) {
          if (clientePersistencia.existeClienteComCpf(dto.getCpf())) {
            throw new RuntimeException("Já existe um cliente cadastrado com este CPF.");
           }
            persistencia.inserir(pessoa);
        } else {
            persistencia.atualizar(pessoa);
        }
       
    }

    @Override
    public void remover(ClienteDTO dto) {
       ClientePersistencia persistencia = new ClientePersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);
    }

    @Override
    public List<ClienteDTO> listar() {
        List<ClienteDTO> lista = new ArrayList<>();
       ClientePersistencia persistencia = new ClientePersistenciaImpl();
       List<Cliente> pessoas = persistencia.buscar();
       
       for(Cliente pessoa: pessoas){
            String id = pessoa.getId() + "";
            String nome =pessoa.getNome();
            String cpf = pessoa.getCpf();
            String telefone = pessoa.getTelefone();
            String email = pessoa.getEmail();

            ClienteDTO dto = new ClienteDTO(id, cpf, nome, email, telefone);
            lista.add(dto);
       }
       
       return lista;
    }
    
}
