/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author 182120038
 */
public class ClienteDAO {

    public void cadastrarClienteDAO(Cliente cVO) {
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
    }//fim cadastrarClienteDAO

    public ArrayList<Cliente> getClienteBD() {
        Connection con = Conexao.getConexao();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from clientes";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente();
                //lado do java |x| (lado do banco)
                c.setIdCliente(rs.getInt("idcliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                clientes.add(c);
            }
            return clientes;
        } catch (SQLException ex) {
            System.out.println("Erro ao Listar!\n"
                    + ex.getMessage());
        }
        return null;
    }//fim do listar (ArrayList)

    public Cliente getClienteByDoc(String cpf) {
        Connection con = Conexao.getConexao();
        Cliente c = null;
        try {
            Statement stat = con.createStatement();
            String sql = "select * from clientes where cpf = '" + cpf + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                //lado do java |x| (lado do banco)
                c.setIdCliente(rs.getInt("idcliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Consultar CPF!\n"
                    + ex.getMessage());
        }
        return c;
    }// fim getClienteByDoc

}
