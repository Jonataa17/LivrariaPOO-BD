/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author 182120038
 */
public class EditoraDAO {

    public void cadastrarEditoraDAO(Editora eVO) {
        //busca conexão com o BD
        try {
            Connection con = Conexao.getConexao();
            //cria espaço de trabalho SQL, é a area no Java onde vamos executar os Scripts SQL
            String sql;

            sql = "insert into editoras values"
                    + "(null, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, eVO.getNmEditora());
            pst.setString(2, eVO.getCnpj());
            pst.setString(3, eVO.getEndereco());
            pst.setString(4, eVO.getTelefone());
            pst.setString(5, eVO.getGerente());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar!\n"
                    + ex.getMessage());
        }
    }//fim cadastrarEditoraDAO

    public ArrayList<Editora> getEditoraDAO() {
        ArrayList<Editora> editoras = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            Statement stat = con.createStatement();
            String sql = "select * from editoras";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Editora e = new Editora();
                //lado do java |x| (lado do banco)
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setCnpj(rs.getString("cnpj"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));

                editoras.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao Listar!\n"
                    + ex.getMessage());
        }
        return editoras;
    }//fim do listar (ArrayList)

    public Editora getEditoraByDoc(String cnpj) {

        Editora e = new Editora();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from editoras where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnpj);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //lado do java |x| (lado do banco)
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setCnpj(rs.getString("cnpj"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Consultar CNPJ!\n"
                    + ex.getMessage());
        }
        return e;
    }// fim getEditoraByDoc

    public void deletarEditoraDAO(String cnpj) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from editoras where = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnpj);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar Editora!\n"
                    + ex.getMessage());
        }
    }//fim deletarEditoraDAO

    public void atualizaEditoraByDoc(Editora eVO) {

        try {
            Connection con = Conexao.getConexao();
            String sql = "update editoras set nomeEditora = ?, endereco = ?, telefone = ?, gerente = ? " //esse espaço no final é importante
                    + "where cnpj = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, eVO.getNmEditora());
            pst.setString(2, eVO.getEndereco());
            pst.setString(3, eVO.getTelefone());
            pst.setString(4, eVO.getGerente());
            pst.setString(5, eVO.getCnpj());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar o Editora!\n"
                    + ex.getMessage());
        }

    }//fim atualizaEditoraByDoc
}
