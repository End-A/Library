/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Impl;

import br.ufmt.biblioteca.Persistencia.ClientePersistencia;
import br.ufmt.biblioteca.Persistencia.Entidades.Cliente;
import java.util.List;

import java.sql.SQLException;

import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Usuario
 */
public class ClientePersistenciaImpl implements ClientePersistencia {
    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(cpf, nome, email, telefone) VALUES (?,?,?,?);";
        List parametros = new ArrayList();
       
        parametros.add(cliente.getCpf());
         parametros.add(cliente.getNome());
        parametros.add(cliente.getEmail());
        parametros.add(cliente.getTelefone());
        
        bd.executar(sql, parametros);
    }

    @Override
    public void remover(int id) {
        String sql =  "DELETE FROM cliente WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros);
    }

    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(cliente.getNome());
        parametros.add(cliente.getCpf());
        parametros.add(cliente.getEmail());
        parametros.add(cliente.getTelefone());
        parametros.add(cliente.getId());
        
        bd.executar(sql, parametros);
    }

    @Override
    public List<Cliente> buscar() {
        List<Cliente> lista = new ArrayList();
        String sql = "SELECT * FROM cliente;";
        ResultSet rs= bd.executarQuery(sql);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Cliente cliente = new Cliente( id,cpf ,nome, email, telefone);
                lista.add(cliente);
            
            }
        }catch (SQLException erro){
        erro.printStackTrace();
        throw new RuntimeException( "nao foi possivel recuperar dados do banco de dados");
        }
        return lista;
    }
    //uma duvida 
    @Override
   public boolean existeClienteComCpf(String cpf) {
    String sql = "SELECT COUNT(*) FROM cliente WHERE cpf = ?";
    ResultSet rs = null; 
    try {
        List<Object> parametros = new ArrayList<>();
        parametros.add(cpf);
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
//