/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author 182120038
 */
public class Conexao {

    //cria uma conexão com o endereço do BD/Schema
    private static String url = "jdbc:mysql://localhost:3306/livraria";

    //cria uma conexão com user do BD
    private static String user = "root";

    //cria uma conexão com a senha do BD
    private static String pass = "";

    public static Connection getConexao() {
        //inicia cenexão nula
        Connection c = null;

        //tenta estabelecer conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            //caso haja erro na conexão
            System.out.println("Erro ao conectar no Banco de Dados!" + e.getMessage());
        }

        return c;
    }
}
