/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Impl;

import br.ufmt.biblioteca.Persistencia.Entidades.LivrosEmprestados;
import br.ufmt.biblioteca.Persistencia.LivrosEmprestadosPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class LivrosEmprestadosPersistenciaImpl implements LivrosEmprestadosPersistencia {
        private BancoDeDados bd = new BancoDeDados();
    
    
    @Override
       public void inserir(LivrosEmprestados livrosEmprestados) {
        String sql = "INSERT INTO livros_emprestados(id_emprestimo, id_livro) VALUES (?,?);";
        List parametros = new ArrayList();
        parametros.add(livrosEmprestados.getIdEmprestimo());
        parametros.add(livrosEmprestados.getIdLivro());
  
        
        bd.executar(sql, parametros);
       }
       
       
    @Override
    public void remover(int id, int idLivro) {
        String sql =  "DELETE FROM livros_emprestados WHERE id_emprestimo = ? AND id_livro = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
         parametros.add(idLivro);
        bd.executar(sql, parametros);
    }

    @Override
    public List<LivrosEmprestados> buscar() {
        List<LivrosEmprestados> lista = new ArrayList();
        String sql = "SELECT * FROM livros_emprestados;";
        ResultSet rs= bd.executarQuery(sql);
        try{
            while(rs.next()){
                int idEmprestimo = rs.getInt("id_emprestimo");
               
                int idLivro = rs.getInt("id_livro");
             
                LivrosEmprestados livrosEmprestados = new LivrosEmprestados( idEmprestimo, idLivro);
                lista.add(livrosEmprestados);
            
            }
        }catch (SQLException erro){
        erro.printStackTrace();
        throw new RuntimeException( "nao foi possivel recuperar dados do banco de dados");
        }
        return lista;
    }

  
    @Override
    public void atualizar(LivrosEmprestados livrosEmprestados) {
        String sql = "UPDATE livros_emprestados SET id_livro = ? WHERE id_emprestimo = ?;";
        List parametros = new ArrayList();
        parametros.add(livrosEmprestados.getIdLivro());
        parametros.add(livrosEmprestados.getIdEmprestimo());
   
        
        bd.executar(sql, parametros);
    }

    @Override
    public boolean ExisteEmprestimo(String id) {
        String sql = "SELECT COUNT(*) FROM emprestimo WHERE id = ?";
    ResultSet rs = null; 
    try {
        List<Object> parametros = new ArrayList<>();
        int idEmprestimo = Integer.parseInt(id);
        parametros.add(idEmprestimo);
        rs = bd.executarQuery(sql, parametros);
        if (rs.next()) {
            return rs.getInt(1) > 0; // Retorna true se a contagem for maior que zero
        }
        return false;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Em caso de erro, retorna false
    } finally {
        // É importante fechar o ResultSet para liberar recursos
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
      }
    }
    @Override
    public boolean ExisteLivro(String id) {
        String sql = "SELECT COUNT(*) FROM livro WHERE id = ?";
    ResultSet rs = null; 
    try {
        List<Object> parametros = new ArrayList<>();
        int idLivro = Integer.parseInt(id);
        parametros.add(idLivro);
        rs = bd.executarQuery(sql, parametros);
        if (rs.next()) {
            return rs.getInt(1) > 0; // Retorna true se a contagem for maior que zero
        }
        return false;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Em caso de erro, retorna false
    } finally {
        // É importante fechar o ResultSet para liberar recursos
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    } 
    
     @Override
    public boolean existeLivroEmprestado(int idEmprestimo, int idLivro) {
        String sql = "SELECT COUNT(*) FROM livros_emprestados WHERE id_emprestimo = ? AND id_livro = ?";
        try {
         List<Object> parametros = new ArrayList<>();
            parametros.add(idEmprestimo);
            parametros.add(idLivro);
             ResultSet rs = bd.executarQuery(sql, parametros);
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}
