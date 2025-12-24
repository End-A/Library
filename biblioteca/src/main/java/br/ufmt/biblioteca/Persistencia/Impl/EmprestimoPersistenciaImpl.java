/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.Persistencia.Impl;

import br.ufmt.biblioteca.Persistencia.EmprestimoPersistencia;
import br.ufmt.biblioteca.Persistencia.Entidades.Emprestimo;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class EmprestimoPersistenciaImpl implements EmprestimoPersistencia {
    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void inserir(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo(id_cliente, data_emprestimo, data_devolucao, devolvido) VALUES (?,?,?,?);";
        List parametros = new ArrayList();
        parametros.add(emprestimo.getIdCliente());
        parametros.add(emprestimo.getDataEmprestimo());
        parametros.add(emprestimo.getDataDevolucao());
        parametros.add(emprestimo.isDevolvido());
        
        bd.executar(sql, parametros);
    }

    @Override
    public void remover(int id) {
        String sql =  "DELETE FROM emprestimo WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros);
    }

    @Override
    public void atualizar(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimo SET id_cliente = ?, data_emprestimo = ? , data_devolucao = ?, devolvido = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(emprestimo.getIdCliente());
        parametros.add(emprestimo.getDataEmprestimo());
        parametros.add(emprestimo.getDataDevolucao());
        parametros.add(emprestimo.isDevolvido());
        parametros.add(emprestimo.getId());
        
        bd.executar(sql, parametros);
    }

    @Override
    public List<Emprestimo> buscar() {
        List<Emprestimo> lista = new ArrayList();
        String sql = "SELECT * FROM emprestimo;";
        ResultSet rs= bd.executarQuery(sql);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                int id_cliente = rs.getInt("id_cliente");
                Date dataEmprestimo = rs.getDate("data_emprestimo");
                Date dataDevolucao = rs.getDate("data_devolucao");
                Boolean devolvido = rs.getBoolean("devolvido");
                System.out.println("na persistencia: " + id_cliente );
                Emprestimo emprestimo = new Emprestimo( id ,id_cliente ,dataEmprestimo , dataDevolucao, devolvido);
                lista.add(emprestimo);
                 System.out.println("na persistencia: " + emprestimo.getIdCliente() );
            }
        }catch (SQLException erro){
        erro.printStackTrace();
        throw new RuntimeException( "nao foi possivel recuperar dados do banco de dados");
        }
        return lista;
    }

    @Override
    public boolean existeCliente(String id)  {
    String sql = "SELECT COUNT(*) FROM cliente WHERE id = ?";
    ResultSet rs = null; 
    try {
        List<Object> parametros = new ArrayList<>();
        int idEmp = Integer.parseInt(id);
        parametros.add(idEmp);
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
