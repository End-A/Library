/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Impl;

import br.ufmt.biblioteca.Persistencia.AutorPersistencia;
import br.ufmt.biblioteca.Persistencia.Entidades.Autor;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Usuario
 */
public class AutorPersistenciaImpl implements AutorPersistencia{
    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void inserir(Autor autor) {
        String sql = "INSERT INTO autor(nome, biografia) VALUES (?,?);";
        List parametros = new ArrayList();
        parametros.add(autor.getNome());
        parametros.add(autor.getBiografia());
        
        bd.executar(sql, parametros);
    }

    @Override
    public void remover(int id) {
        String sql =  "DELETE FROM autor WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar(Autor autor) {
        String sql = "UPDATE autor SET nome = ?, biografia = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(autor.getNome());
        parametros.add(autor.getBiografia());
  
        parametros.add(autor.getId());
        
        bd.executar(sql, parametros);
    }

    @Override
    public List<Autor> buscar() {
         List<Autor> lista = new ArrayList();
        String sql = "SELECT * FROM autor;";
        ResultSet rs= bd.executarQuery(sql);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String biografia = rs.getString("biografia");
                Autor autor = new Autor(id, nome , biografia);
                lista.add(autor);
            
            }
        }catch (SQLException erro){
        erro.printStackTrace();
        throw new RuntimeException( "nao foi possivel recuperar dados do banco de dados");
        }
        return lista;
    }
    
}
