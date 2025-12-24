/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.service.Impl;

import br.ufmt.biblioteca.Persistencia.Entidades.Livro;
import br.ufmt.biblioteca.Persistencia.Impl.LivroPersistenciaImpl;
import br.ufmt.biblioteca.Persistencia.LivroPersistencia;
import br.ufmt.biblioteca.Ui.dto.LivroDTO;
import br.ufmt.biblioteca.service.LivroService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LivroServiceImpl implements LivroService {
    private LivroPersistencia livropersistencia = new LivroPersistenciaImpl();
    @Override
    public void salvar(LivroDTO dto) {
        if(dto.getTitulo().equals("")){
            throw new RuntimeException("Título é obrigatório!");
        }
        
        if (!livropersistencia.existeAutor(dto.getIdAutor())) {
            throw new RuntimeException("Não existe esse autor.");
        }
        int id = 0;
        
        int idAutor = Integer.parseInt(dto.getIdAutor());
        if (!dto.getId().equals("")) {
            id = Integer.parseInt(dto.getId());
        }
        
        Livro pessoa = new Livro(id,dto.getTitulo() ,idAutor, dto.getResumo() , dto.isDisponivel());
        
        LivroPersistencia persistencia = new LivroPersistenciaImpl();
        
        if (id == 0) {
            persistencia.inserir(pessoa);
        } else {
            persistencia.atualizar(pessoa);
        }
    }

    @Override
    public void remover(LivroDTO dto) {
        LivroPersistencia persistencia = new LivroPersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);
    }

    @Override
    public List<LivroDTO> listar() {
        List<LivroDTO> lista = new ArrayList<>();
       LivroPersistencia persistencia = new LivroPersistenciaImpl();
       List<Livro> livros = persistencia.buscar();
       
       for(Livro livro: livros){
            String id = livro.getId() + "";
            String titulo =livro.getTitulo();
            String resumo = livro.getResumo();
            boolean disponivel = livro.isDisponivel();
            String IdAutor = livro.getIdAutor() + "";

            LivroDTO dto = new LivroDTO(id, titulo, IdAutor,resumo,  disponivel);
            lista.add(dto);
       }
       
       return lista;
    }
    
}
