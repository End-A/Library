/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author aluno
 */
public class BancoDeDados {
    
    public Connection conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/TrabalhoPOO";
        Connection con = DriverManager.getConnection(url, "postgres", "12345");
        return con;
    }
    
    public void fecharConexao(){
        
    }
    //fiz um novo pois a data estava com conflito
    public void executar(String sql, List parametros) {
    try (Connection con = conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        for (int i = 0; i < parametros.size(); i++) {
            Object parametro = parametros.get(i);
            if (parametro instanceof java.util.Date) {
                pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) parametro).getTime()));
            } else {
                pstmt.setObject(i + 1, parametro);
            }
        }
        pstmt.execute();
        fecharConexao();
    } catch (SQLException erro) {
        erro.printStackTrace();
        throw new RuntimeException("Erro ao inserir/atualizar no banco de dados!");
    }
}
    
    
    
    public ResultSet executarQuery(String sql) {
        try {
            Connection con = conectar();
            return con.createStatement().executeQuery(sql);
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Erro ao consultar no banco de dados!");
        }
    }
     public ResultSet executarQuery(String sql, List<?> parametros) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = conectar();
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < parametros.size(); i++) {
                pstmt.setObject(i + 1, parametros.get(i));
            }
            rs = pstmt.executeQuery();
            return rs; // A conexão e o PreparedStatement serão fechados externamente
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao consultar o banco de dados!", erro);
        }
    }
}
