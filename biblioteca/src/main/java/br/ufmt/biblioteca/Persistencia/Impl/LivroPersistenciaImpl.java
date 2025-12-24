/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Impl;

import br.ufmt.biblioteca.Persistencia.Entidades.Livro;
import br.ufmt.biblioteca.Persistencia.LivroPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class LivroPersistenciaImpl implements LivroPersistencia {
    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void inserir(Livro livro) {
        String sql = "INSERT INTO livro(nome, id_autor, resumo, disponivel) VALUES (?,?,?,?);";
        List parametros = new ArrayList();
        parametros.add(livro.getTitulo());
        parametros.add(livro.getIdAutor());
        parametros.add(livro.getResumo());
        parametros.add(livro.isDisponivel());
        
        bd.executar(sql, parametros);
    }
      

    @Override
    public void remover(int id) {
        String sql =  "DELETE FROM livro WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros);
    }

    @Override
    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET nome = ?, id_autor = ? , resumo = ?, disponivel = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(livro.getTitulo());
        parametros.add(livro.getIdAutor());
        parametros.add(livro.getResumo());
         parametros.add(livro.isDisponivel());
        parametros.add(livro.getId());
        
        bd.executar(sql, parametros);
    }

    @Override
    public List<Livro> buscar() {
        List<Livro> lista = new ArrayList();
        String sql = "SELECT * FROM livro;";
        ResultSet rs= bd.executarQuery(sql);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String Titulo = rs.getString("nome");
                int id_autor = rs.getInt("id_autor");
                String resumo = rs.getString("resumo");
                Boolean disponivel = rs.getBoolean("disponivel");
                Livro livro = new Livro( id ,Titulo, id_autor, resumo, disponivel);
                lista.add(livro);
            
            }
        }catch (SQLException erro){
        erro.printStackTrace();
        throw new RuntimeException( "nao foi possivel recuperar dados do banco de dados");
        }
        return lista;
    }
    
    @Override
    public boolean existeAutor(String id){
    String sql = "SELECT COUNT(*) FROM autor WHERE id = ?";
    ResultSet rs = null; 
    try {
        List<Object> parametros = new ArrayList<>();
        int idAutor = Integer.parseInt(id);
        parametros.add(idAutor);
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

   
}

