/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.biblioteca.service.Impl;

import br.ufmt.biblioteca.Persistencia.EmprestimoPersistencia;
import br.ufmt.biblioteca.Persistencia.Entidades.Emprestimo;
import br.ufmt.biblioteca.Persistencia.Impl.EmprestimoPersistenciaImpl;
import br.ufmt.biblioteca.Ui.dto.EmprestimoDTO;
import br.ufmt.biblioteca.service.EmprestimoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class EmprestimoServiceImpl implements EmprestimoService {
    private EmprestimoPersistencia emprestimoPersistencia = new EmprestimoPersistenciaImpl() ;
    @Override
    public void salvar(EmprestimoDTO dto) {
        if(dto.getIdCliente().equals("")){
            throw new RuntimeException("é obrigatorio que haja um cliente!");
        }
        
        if (!emprestimoPersistencia.existeCliente(dto.getIdCliente())) {
            throw new RuntimeException("Não existe esse cliente.");
        }
        int id = 0;
        
        int idCliente = Integer.parseInt(dto.getIdCliente());
        if (!dto.getId().equals("")) {
            id = Integer.parseInt(dto.getId());
        }
        
        Emprestimo pessoa = new Emprestimo(id, idCliente, dto.getDataEmprestimo(),  dto.getDataDevolucao(), dto.isDevolvido());
        
        EmprestimoPersistencia persistencia = new EmprestimoPersistenciaImpl();
        
        if (id == 0) {
            persistencia.inserir(pessoa);
        } else {
            persistencia.atualizar(pessoa);
        }
    }

    @Override
    public void remover(EmprestimoDTO dto) {
        EmprestimoPersistencia persistencia = new EmprestimoPersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);
    }

    @Override
    public List<EmprestimoDTO> listar() {
        List<EmprestimoDTO> lista = new ArrayList<>();
      EmprestimoPersistencia persistencia = new EmprestimoPersistenciaImpl();
       List<Emprestimo> emprestimos = persistencia.buscar();
       
       for(Emprestimo emprestimo: emprestimos){
            String id = emprestimo.getId() + "";
            String idCliente = emprestimo.getIdCliente()+ "";
            Date dataEmprestimo =emprestimo.getDataEmprestimo();
            Date dataDevolucao = emprestimo.getDataDevolucao();
           
            boolean devolvido = emprestimo.isDevolvido();
            
            System.out.println(idCliente + " no service impl");
            EmprestimoDTO dto = new EmprestimoDTO(id, idCliente, dataEmprestimo,  dataDevolucao, devolvido);
            lista.add(dto);
       }
       
       return lista;
    }
    
}
