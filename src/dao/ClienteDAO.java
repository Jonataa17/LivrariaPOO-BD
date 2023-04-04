/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author 182120038
 */
public class ClienteDAO {
    public void cadastrarClienteDAO(Cliente cVO){
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        
        try {
            //cria espaço de trabalho SQL, é a area no Java onde vamos executar os Scripts SQL
            Statement stat = con.createStatement();
            String sql;
            
            sql = "insert into clientes values"
                    + "(null,"
                    + "'" + cVO.getNomeCliente() + "',"
                    + "'" + cVO.getCpf() + "'),";
            stat.execute(sql);
                   
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar!\n"
                    + ex.getMessage());
        }
    }
    
}
