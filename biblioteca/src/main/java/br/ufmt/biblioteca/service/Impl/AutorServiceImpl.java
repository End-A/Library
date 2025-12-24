/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.service.Impl;

import br.ufmt.biblioteca.Persistencia.AutorPersistencia;
import br.ufmt.biblioteca.Persistencia.Entidades.Autor;
import br.ufmt.biblioteca.Persistencia.Impl.AutorPersistenciaImpl;
import br.ufmt.biblioteca.Ui.dto.AutorDTO;
import br.ufmt.biblioteca.service.AutorService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AutorServiceImpl implements AutorService {

    @Override
    public void salvar(AutorDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("Nome é obrigatório!");
        }
        int id = 0;
        
        if (!dto.getId().equals("")) {
            id = Integer.parseInt(dto.getId());
        }
        
        Autor pessoa = new Autor(id, dto.getNome(), dto.getBiografia());
        
        AutorPersistencia persistencia = new AutorPersistenciaImpl();
        
        if (id == 0) {
            persistencia.inserir(pessoa);
        } else {
            persistencia.atualizar(pessoa);
        }
    }

    @Override
    public void remover(AutorDTO dto) {
         AutorPersistencia persistencia = new AutorPersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);
    }

    @Override
    public List<AutorDTO> listar() {
       List<AutorDTO> lista = new ArrayList<>();
       AutorPersistencia persistencia = new AutorPersistenciaImpl();
       List<Autor> pessoas = persistencia.buscar();
       
       for(Autor pessoa: pessoas){
            String id = pessoa.getId() + "";
            String nome =pessoa.getNome();
            String biografia = pessoa.getBiografia();
            

            AutorDTO dto = new AutorDTO(id, nome, biografia);
            lista.add(dto);
       }
       
       return lista;
    }
    
}
