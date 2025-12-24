/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.service.Impl;

import br.ufmt.biblioteca.Persistencia.Entidades.LivrosEmprestados;
import br.ufmt.biblioteca.Persistencia.Impl.LivrosEmprestadosPersistenciaImpl;
import br.ufmt.biblioteca.Persistencia.LivrosEmprestadosPersistencia;
import br.ufmt.biblioteca.Ui.dto.LivrosEmprestadosDTO;
import br.ufmt.biblioteca.service.LivrosEmprestadosService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LivrosEmprestadosServiceImpl implements LivrosEmprestadosService {
    private LivrosEmprestadosPersistencia livrosEmprestadodsPersistencia = new LivrosEmprestadosPersistenciaImpl();
    @Override
    public void salvar(LivrosEmprestadosDTO dto) {
        if(dto.getIdEmprestimo().equals("")){
            throw new RuntimeException("é obrigatorio que haja um emprestimo");
        }
        
        if (!livrosEmprestadodsPersistencia.ExisteEmprestimo(dto.getIdEmprestimo())) {
            throw new RuntimeException("é obrigatorio que haja um emprestimo existente!");
        }
        if(dto.getIdLivro().equals("")){
            throw new RuntimeException("é obrigatorio que haja ao menos 1 livro emprestado");
        }
        
        if (!livrosEmprestadodsPersistencia.ExisteLivro(dto.getIdLivro())) {
            throw new RuntimeException("é obrigatorio que haja um livro existente!");
        }
        int idLivro = Integer.parseInt(dto.getIdLivro());
        int idEmprestimo = Integer.parseInt(dto.getIdEmprestimo());
        
        if (livrosEmprestadodsPersistencia.existeLivroEmprestado(idEmprestimo,idLivro )) {
            throw new RuntimeException("Esse cliente já pegou esse livro, escolha outro!");
        }
       
        
        
        
        LivrosEmprestados livrosemprestados = new LivrosEmprestados(idEmprestimo, idLivro );
        
        LivrosEmprestadosPersistencia persistencia = new LivrosEmprestadosPersistenciaImpl();
        
        if(persistencia.existeLivroEmprestado(idEmprestimo, idLivro)) {
            persistencia.atualizar(livrosemprestados);
            } else {
                persistencia.inserir(livrosemprestados);
        }
    }

    @Override
    public void remover(LivrosEmprestadosDTO dto) {
        LivrosEmprestadosPersistencia persistencia = new LivrosEmprestadosPersistenciaImpl();
        int id = Integer.parseInt(dto.getIdEmprestimo());
        int idLivro = Integer.parseInt(dto.getIdLivro());
        persistencia.remover(id,idLivro);
    }

    @Override
    public List<LivrosEmprestadosDTO> listar() {
      List<LivrosEmprestadosDTO> lista = new ArrayList<>();
      LivrosEmprestadosPersistencia persistencia = new LivrosEmprestadosPersistenciaImpl();
       List<LivrosEmprestados> livrosemprestados = persistencia.buscar();
       
       for(LivrosEmprestados livrosemprestado: livrosemprestados){
            String idEmprestimo = livrosemprestado.getIdEmprestimo()+ "";
            String IdLivro =livrosemprestado.getIdLivro() + "";
            

            LivrosEmprestadosDTO dto = new LivrosEmprestadosDTO(idEmprestimo, IdLivro);
            lista.add(dto);
       }
       
       return lista;
    }
  
    
}
